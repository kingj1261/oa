/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

/**
 * 工资服务
 *
 * @author maping.mp
 * @version $Id: SalaryService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface SalaryService {

    /**
     * 计算当前公司下所有员工的工资
     * @param companyCode           公司code
     * @param companyId             公司id
     */
    void caculateSalary(String companyCode, String companyId);
}
