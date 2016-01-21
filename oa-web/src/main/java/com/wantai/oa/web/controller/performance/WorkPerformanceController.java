/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.performance;

import com.alibaba.fastjson.JSON;
import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.result.Status;
import com.wantai.oa.performance.common.WorkPerformanceService;
import com.wantai.oa.performance.common.request.WorkPerformanceRequest;
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
 * 岗位绩效控制器
 *
 * @author maping.mp
 * @version $Id: WorkPerformanceController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class WorkPerformanceController extends BaseController {

    @Autowired
    protected Validator            validator;

    /** 配置服务对象 */
    @Autowired
    private WorkPerformanceService workPerformanceService;

    /**
     * 根据业务事项查询其事件列表
     * @return              配置数据对象
     */
    @RequestMapping(value = "/workperformance/list", method = RequestMethod.GET)
    public Status queryWorkPerformance(String customerId) {
        return execute(status -> {
            if (StringUtils.isBlank(customerId)) {
                throw new RuntimeException("客户编号不能为空!");
            }
            String companyCode = UserHolder.getUser().getCompanyCode();
            int companyId = UserHolder.getUser().getCompanyId();
            WorkPerformanceRequest config = workPerformanceService.queryWorkPerformance(
                companyCode, companyId + "", customerId);
            status.setData(config);
        });
    }

    /**
     * 新增配置数据
     * @return              配置数据对象
     */
    @RequestMapping(value = "/workperformance/add", method = RequestMethod.POST)
    public Status addPerformanceConfig(HttpServletRequest request) {
        return execute(status -> {
            String datas = request.getParameter(getDataKey());
            if (StringUtils.isBlank(datas)) {
                throw new RuntimeException("请求参数为空");
            }

            try {
                WorkPerformanceRequest workConfig = JSON.parseObject(datas,
                    WorkPerformanceRequest.class);

                Set<ConstraintViolation<WorkPerformanceRequest>> errors = validator
                    .validate(workConfig);
                if (errors.size() > 0) {
                    throw new RuntimeException("请求参数数据错误,错误数[" + errors.size() + "]");
                }
                workPerformanceService.addWorkPerformance(workConfig);
            } catch (Exception e) {
                throw new RuntimeException("绩效系数数据解析错误");
            }
        });
    }
}
