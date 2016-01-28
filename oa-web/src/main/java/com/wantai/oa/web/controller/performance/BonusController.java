/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.performance;

import com.alibaba.fastjson.JSON;
import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.result.Status;
import com.wantai.oa.biz.shared.vo.BizBonusVO;
import com.wantai.oa.biz.shared.vo.BizEventVO;
import com.wantai.oa.biz.shared.vo.BizItemVO;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.biz.shared.vo.SubBizEventVO;
import com.wantai.oa.common.lang.enums.CustomerTypeEnum;
import com.wantai.oa.performance.common.BonusService;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.BonusRequest;
import com.wantai.oa.web.controller.common.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 岗位奖金/提成控制器
 *
 * @author maping.mp
 * @version $Id: BonusController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class BonusController extends BaseController {

    @Autowired
    protected Validator   validator;
    /** 配置服务对象 */
    @Autowired
    private ConfigService configService;

    @Autowired
    private BonusService  bonusService;

    /**
     * 根据业务事项查询其事件列表
     * @return              配置数据对象
     */
    @RequestMapping(value = "/bonus/list", method = RequestMethod.GET)
    public Status queryBonusEventList(String configType, String bizItem, String customerId) {
        return execute(status -> {
            String companyCode = UserHolder.getUser().getCompanyCode();
            int companyId = UserHolder.getUser().getCompanyId();

            ConfigVO configVO = configService.queryConfigs(companyCode, companyId, configType,
                true, bizItem);

            if (configVO != null && configVO.getBizItems() != null) {

                Set<BizItemVO> itemVOList = null;
                if (StringUtils.isNotBlank(bizItem)) {
                    itemVOList = configVO.getBizItems().stream()
                        .filter(bizItemVO -> StringUtils.equals(bizItemVO.getBizItem(), bizItem))
                        .collect(Collectors.toSet());
                } else {
                    itemVOList = configVO.getBizItems();
                }

                List<BizEventVO> events = itemVOList.size() == 0 ? new ArrayList<>() : itemVOList
                    .iterator().next().getBizEvents();

                List<BizBonusVO> list = new ArrayList<>();
                events.forEach(event -> {

                    BizBonusVO vo = new BizBonusVO();
                    vo.setConfigId(event.getConfigId());
                    vo.setBizEvent(event.getBizEvent());
                    vo.setBizEventName(event.getBizEventName());
                    vo.setBizItem(event.getBizItem());
                    vo.setOrder(event.getOrder());

                    //设置单位
                    vo.setUnit(getUnit(event));

                    //设置是否启用
                    vo.setEnable(getEnableStatus(event, CustomerTypeEnum.COMPANY));

                    //设置值
                    vo.setCompanyValue(getValue(event, CustomerTypeEnum.COMPANY));
                    if (StringUtils.isNotBlank(customerId)) {
                        vo.setCustomerId(customerId);
                        vo.setCustomValue(getValue(event, CustomerTypeEnum.CUSTOMER));
                        vo.setEnable(getEnableStatus(event, CustomerTypeEnum.CUSTOMER));
                    }

                    list.add(vo);
                });
                status.setData(list);
            } else {
                status.setData(new ArrayList<>());
            }
        });
    }

    private boolean getEnableStatus(BizEventVO event, CustomerTypeEnum customer) {
        boolean result = false;
        if (!CollectionUtils.isEmpty(event.getSubEventList())) {
            Optional<SubBizEventVO> found = event.getSubEventList().stream()
                .filter(data -> StringUtils.equals(data.getTarget(), customer.getCode()))
                .findFirst();
            result = found.isPresent() ? Boolean.parseBoolean(found.get().getEnable()) : false;
        }
        return result;
    }

    private String getUnit(BizEventVO event) {
        StringBuilder sb = new StringBuilder();
        if (!CollectionUtils.isEmpty(event.getSubEventList())) {
            Optional<SubBizEventVO> found = event.getSubEventList().stream().findFirst();
            sb.append(found.isPresent() ? "元/次" : found.get().getValue());
        }
        return sb.toString();
    }

    /**
     * 获取值
     * @param event
     * @param customer
     * @return
     */
    private String getValue(BizEventVO event, CustomerTypeEnum customer) {
        StringBuilder sb = new StringBuilder("0");
        if (!CollectionUtils.isEmpty(event.getSubEventList())) {
            Optional<SubBizEventVO> found = event.getSubEventList().stream()
                .filter(data -> StringUtils.equals(data.getTarget(), customer.getCode()))
                .findFirst();
            sb.setLength(0);
            sb.append(found.isPresent() ? found.get().getValue() : "0");
        }
        return sb.toString();
    }

    /**
     * 新增子配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/bonus/add", method = RequestMethod.POST)
    public Status addBonusConfig(HttpServletRequest request) {
        return execute(status -> {
            String datas = request.getParameter(getDataKey());
            if (StringUtils.isBlank(datas)) {
                throw new RuntimeException("请求参数为空");
            }

            try {
                BonusRequest bonusRequest = JSON.parseObject(datas, BonusRequest.class);
                Set<ConstraintViolation<BonusRequest>> errors = validator.validate(bonusRequest);
                if (errors.size() > 0) {
                    throw new RuntimeException("请求参数数据错误,错误数[" + errors.size() + "]");
                }

                bonusService.addBonusConfig(bonusRequest);
            } catch (Exception e) {
                throw new RuntimeException("岗位奖金(提成)系数数据解析错误");
            }
        });
    }
}
