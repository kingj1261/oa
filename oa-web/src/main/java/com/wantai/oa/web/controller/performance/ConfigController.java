/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.performance;

import com.alibaba.fastjson.JSON;
import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.result.Status;
import com.wantai.oa.biz.shared.vo.BizEventVO;
import com.wantai.oa.biz.shared.vo.BizItemVO;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.RatioRequest;
import com.wantai.oa.web.controller.common.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 绩效系数管理控制器
 *
 * @author maping.mp
 * @version $Id: ConfigController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class ConfigController extends BaseController {

    @Autowired
    protected Validator   validator;

    /** 配置服务对象 */
    @Autowired
    private ConfigService configService;

    /**
     * 获取所有配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/config/list", method = RequestMethod.GET)
    public Status queryAllBizItems(String configType) {
        return execute(status -> {
            String companyCode = UserHolder.getUser().getCompanyCode();
            int companyId = UserHolder.getUser().getCompanyId();
            ConfigVO configVO = configService.queryConfigs(companyCode, companyId, configType,
                false, null);
            status.setData(configVO);
        });
    }

    /**
     * 根据业务事项查询其事件列表
     * @return              配置数据对象
     */
    @RequestMapping(value = "/subconfig/list", method = RequestMethod.GET)
    public Status queryEventList(String configType, String bizItem) {
        return execute(status -> {
            String companyCode = UserHolder.getUser().getCompanyCode();
            int companyId = UserHolder.getUser().getCompanyId();

            ConfigVO configVO = configService.queryConfigs(companyCode, companyId, configType,
                true, bizItem);

            if (configVO != null && configVO.getBizItems() != null) {
                Set<BizItemVO> itemVOList = configVO.getBizItems().stream()
                    .filter(bizItemVO -> StringUtils.equals(bizItemVO.getBizItem(), bizItem))
                    .collect(Collectors.toSet());
                List<BizEventVO> events = itemVOList.size() == 0 ? new ArrayList<>() : itemVOList
                    .iterator().next().getBizEvents();
                status.setData(events);
            } else {
                status.setData(new ArrayList<>());
            }
        });
    }

    /**
     * 新增子配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/config/add", method = RequestMethod.POST)
    public Status addConfig(HttpServletRequest request, Long businessConfigId) {
        return execute(status -> {
            String datas = request.getParameter(getDataKey());
            if (StringUtils.isBlank(datas)) {
                throw new RuntimeException("请求参数为空");
            }

            if (businessConfigId == null) {
                throw new RuntimeException("主配置id不能为空");
            }

            try {
                List<RatioRequest> requests = JSON.parseArray(datas, RatioRequest.class);
                requests.forEach(ratio -> {
                    Set<ConstraintViolation<RatioRequest>> errors = validator.validate(ratio);
                    if (errors.size() > 0) {
                        throw new RuntimeException("请求参数数据错误,错误数[" + errors.size() + "]");
                    }
                });
                configService.addConfig(businessConfigId, requests);
            } catch (Exception e) {
                throw new RuntimeException("绩效系数数据解析错误");
            }
        });
    }
}
