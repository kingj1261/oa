/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;
import com.wantai.oa.common.lang.enums.UnitEnum;

import java.util.Date;

/**
 * 车辆销售记录对象
 *
 * @author maping.mp
 * @version $Id: SaleOrderDo.java, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class PerformanceDo extends BaseDo {
    private String customerId;
    private Date   startTime;
    private Date   endTime;
    private double basicSalary;
    private double starSalary;
    private double lowestSalary;
    private double workYearsSalary;
    private double maxWorkYearsSalary;
    private double betAmount;
    private String currency = UnitEnum.CNY.getCode();
    private double socialBasicAmount;
    private double socialPercent;
    private double fundBasicAmount;
    private double fundPercent;

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

    public double getMaxWorkYearsSalary() {
        return maxWorkYearsSalary;
    }

    public void setMaxWorkYearsSalary(double maxWorkYearsSalary) {
        this.maxWorkYearsSalary = maxWorkYearsSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getStarSalary() {
        return starSalary;
    }

    public void setStarSalary(double starSalary) {
        this.starSalary = starSalary;
    }

    public double getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(double lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public double getWorkYearsSalary() {
        return workYearsSalary;
    }

    public void setWorkYearsSalary(double workYearsSalary) {
        this.workYearsSalary = workYearsSalary;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getSocialBasicAmount() {
        return socialBasicAmount;
    }

    public void setSocialBasicAmount(double socialBasicAmount) {
        this.socialBasicAmount = socialBasicAmount;
    }

    public double getSocialPercent() {
        return socialPercent;
    }

    public void setSocialPercent(double socialPercent) {
        this.socialPercent = socialPercent;
    }

    public double getFundBasicAmount() {
        return fundBasicAmount;
    }

    public void setFundBasicAmount(double fundBasicAmount) {
        this.fundBasicAmount = fundBasicAmount;
    }

    public double getFundPercent() {
        return fundPercent;
    }

    public void setFundPercent(double fundPercent) {
        this.fundPercent = fundPercent;
    }
}
