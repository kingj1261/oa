/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.performance;

import com.wantai.oa.biz.shared.result.Status;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.ConfigRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置管理控制器
 *
 * @author maping.mp
 * @version $Id: ConfigController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class ConfigController {

    /** 配置服务对象 */
    @Autowired
    private ConfigService configService;

    /**
     * 获取所有配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/config/list", method = RequestMethod.GET)
    public List<ConfigVO> queryConfigs(String companyCode, int companyId, String configType) {
        return configService.queryConfigs(companyCode, companyId, configType);
    }

    /**
     * 新增子配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/config/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Status addConfig(HttpServletRequest servletRequest, ConfigRequest request) {
        Status status = new Status();
        try {
            List<ConfigRequest> requests = new ArrayList<>();
            requests.add(request);
            configService.addConfig(requests);
        } catch (Exception e) {
            status.setSuccess(false);
            status.setErrorCode(e.getMessage());
            status.setErrorMessage(e.getMessage());
        }
        return status;
    }

    /**
     * 配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/config/update", method = RequestMethod.PUT)
    public Status updateConfig(ConfigRequest request) {
        Status status = new Status();
        try {
            List<ConfigRequest> requests = new ArrayList<>();
            requests.add(request);
            configService.update(requests);
        } catch (Exception e) {
            status.setSuccess(false);
            status.setErrorCode(e.getMessage());
            status.setErrorMessage(e.getMessage());
        }
        return status;
    }
}
