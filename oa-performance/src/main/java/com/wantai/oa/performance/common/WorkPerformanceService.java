/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

import com.wantai.oa.performance.common.request.WorkPerformanceRequest;

/**
 * 岗位绩效配置服务
 *
 * @author maping.mp
 * @version $Id: WorkPerformanceService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface WorkPerformanceService {

    /**
     * 新增配置对象
     * @param workConfig    请求参数
     */
    void addWorkPerformance(WorkPerformanceRequest workConfig);

    /**
     * 查询当前用户的岗位绩效设置
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param customerId            用户id
     * @return                      配置结果
     */
    WorkPerformanceRequest queryWorkPerformance(String companyCode, String companyId,
                                                String customerId);
}
