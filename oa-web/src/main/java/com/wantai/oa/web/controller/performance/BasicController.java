/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.performance;

import com.alibaba.fastjson.JSON;
import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.result.Status;
import com.wantai.oa.biz.shared.vo.BasicConfigVO;
import com.wantai.oa.performance.common.BasicService;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.BasicRequest;
import com.wantai.oa.web.controller.common.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 基础设置税率控制器
 *
 * @author maping.mp
 * @version $Id: BasicController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class BasicController extends BaseController {

    @Autowired
    protected Validator validator;

    /**
     * 配置服务对象
     */
    @Autowired
    private ConfigService configService;

    /**
     * 基础配置服务
     */
    @Autowired
    private BasicService basicService;

    /**
     * 保存基础配置对象
     *
     * @return 修改结果
     */
    @RequestMapping(value = "/basic/add", method = RequestMethod.POST)
    public Status addBasicConfig(HttpServletRequest request) {
        return execute(status -> {
            String datas = request.getParameter(getDataKey());
            if (StringUtils.isBlank(datas)) {
                throw new RuntimeException("请求参数为空");
            }

            try {
                BasicRequest basicRequest = JSON.parseObject(datas, BasicRequest.class);
                Set<ConstraintViolation<BasicRequest>> validations = validator
                        .validate(basicRequest);

                if (validations.size() > 0) {
                    throw new RuntimeException("数据请求错误");
                }

                basicService.addBasicConfig(basicRequest);

            } catch (Exception e) {
                throw new RuntimeException("公共数据解析错误", e);
            }
        });
    }

    /**
     * 公共配置数据查询接口
     *
     * @param request http请求对象
     * @return 配置数据对象
     */
    @RequestMapping(value = "/basic/list", method = RequestMethod.GET)
    public Status queryBasicConfig(HttpServletRequest request) {
        Status status1 = execute(status -> {
            BasicConfigVO configVO = basicService.queryBasicConfig(UserHolder.getUser()
                    .getCompanyCode(), UserHolder.getUser().getCompanyId() + "");
            status.setData(configVO);
        });
        return status1;
    }


    @RequestMapping(value = "/basic/set", method = RequestMethod.GET)
    public String queryBasicSet() {
        return "info/info_setbase";
    }

}
