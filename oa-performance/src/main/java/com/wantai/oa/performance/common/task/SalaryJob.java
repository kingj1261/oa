/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.task;

import com.wantai.oa.performance.common.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 工资计算job
 *
 * @author maping.mp
 * @version $Id: SalaryJob.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class SalaryJob {

    @Autowired
    private SalaryService salaryService;

    @Scheduled(cron = "59 59 23 * * ?")
    public void execute() {
        salaryService.caculateSalary();
    }
}
