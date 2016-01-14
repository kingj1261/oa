/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.performance;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 绩效系数管理控制器
 *
 * @author maping.mp
 * @version $Id: RatioController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class RatioController extends BaseController {

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
    public Status addConfig(HttpServletRequest request, HttpServletResponse response,
                            @Valid RatioRequest ratioRequest, BindingResult result) {
        return execute(status -> {
            if (result.hasErrors()) {
                throw new RuntimeException("参数错误!");
            }
            List<RatioRequest> requests = new ArrayList<>();
            requests.add(ratioRequest);
            configService.addConfig(requests);
        });
    }

    /**
     * 配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/config/update", method = RequestMethod.PUT)
    public Status updateConfig(RatioRequest request) {
        return execute(status -> {
            List<RatioRequest> requests = new ArrayList<>();
            requests.add(request);
            configService.update(requests);
        });
    }
}
