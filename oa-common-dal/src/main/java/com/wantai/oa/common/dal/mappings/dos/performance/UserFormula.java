/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;
import com.wantai.oa.common.lang.enums.CacluTypeEnum;
import com.wantai.oa.common.lang.enums.KpiTypeEnum;

import java.util.Date;

/**
 * 用户事项事件设置
 *
 * @author maping.mp
 * @version $Id: UserFormula.java, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class UserFormula extends BaseDo {
    private String customerId;
    private Date   startTime;
    private Date   endTime;
    private String hasBasicSalary;
    private String hasStartSalary;
    private String hasLowestSalary;
    private String hasWorkYearsSalary;
    private String checkRule      = KpiTypeEnum.BET.getCode();
    private String ratioCacluType = CacluTypeEnum.AVG.getCode();
    private String hasSubsitySalary;
    private String hasBonusSalary;
    private String hasDeductSalary;
    private String hasWithholdSalary;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getHasBasicSalary() {
        return hasBasicSalary;
    }

    public void setHasBasicSalary(String hasBasicSalary) {
        this.hasBasicSalary = hasBasicSalary;
    }

    public String getHasStartSalary() {
        return hasStartSalary;
    }

    public void setHasStartSalary(String hasStartSalary) {
        this.hasStartSalary = hasStartSalary;
    }

    public String getHasLowestSalary() {
        return hasLowestSalary;
    }

    public void setHasLowestSalary(String hasLowestSalary) {
        this.hasLowestSalary = hasLowestSalary;
    }

    public String getHasWorkYearsSalary() {
        return hasWorkYearsSalary;
    }

    public void setHasWorkYearsSalary(String hasWorkYearsSalary) {
        this.hasWorkYearsSalary = hasWorkYearsSalary;
    }

    public String getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(String checkRule) {
        this.checkRule = checkRule;
    }

    public String getRatioCacluType() {
        return ratioCacluType;
    }

    public void setRatioCacluType(String ratioCacluType) {
        this.ratioCacluType = ratioCacluType;
    }

    public String getHasSubsitySalary() {
        return hasSubsitySalary;
    }

    public void setHasSubsitySalary(String hasSubsitySalary) {
        this.hasSubsitySalary = hasSubsitySalary;
    }

    public String getHasBonusSalary() {
        return hasBonusSalary;
    }

    public void setHasBonusSalary(String hasBonusSalary) {
        this.hasBonusSalary = hasBonusSalary;
    }

    public String getHasDeductSalary() {
        return hasDeductSalary;
    }

    public void setHasDeductSalary(String hasDeductSalary) {
        this.hasDeductSalary = hasDeductSalary;
    }

    public String getHasWithholdSalary() {
        return hasWithholdSalary;
    }

    public void setHasWithholdSalary(String hasWithholdSalary) {
        this.hasWithholdSalary = hasWithholdSalary;
    }
}
