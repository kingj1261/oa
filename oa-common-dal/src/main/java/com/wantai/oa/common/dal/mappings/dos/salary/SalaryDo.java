/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.salary;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

import java.util.Date;

/**
 * 工资DO对象
 *
 * @author maping.mp
 * @version $Id: SalaryDo.java, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class SalaryDo extends BaseDo {

    /** 客户编号*/
    private String customerId;

    /** 基本工资*/
    private double basicSalary            = 0;

    /** 星级工资*/
    private double starSalary             = 0;

    /** 保底工资*/
    private double lowestSalary           = 0;

    /** 工龄工资*/
    private double workYearSalary         = 0;

    /** 考核系数值*/
    private double kpi                    = 0;

    /** 补贴工资*/
    private double subsitySalary          = 0;

    /** 奖金金额*/
    private double bonusSalary            = 0;

    /** 岗位奖金金额*/
    private double jjSalary               = 0;

    /** 岗位提成金额*/
    private double tcSalary               = 0;

    /** 扣款工资*/
    private double duductSalary           = 0;

    /** 代扣工资*/
    private double withholdSalary         = 0;

    /** 社保缴存金额*/
    private double socailAmount           = 0;

    /** 公积金缴存金额*/
    private double fundAmunt              = 0;

    /** 缴存个税*/
    private double revenueAmount          = 0;

    /** 保底工资差额*/
    private double lowestSalaryDifference = 0;

    /** 应扣款合计*/
    private double totalWithholdingAmount = 0;

    /** 应发工资*/
    private double grossSalary            = 0;

    /** 应发工资*/
    private double salary                 = 0;

    /** 实发工资*/
    private double realSalary             = 0;

    /** 开始日期*/
    private Date   startTime;

    /** 结束日期*/
    private Date   endTime;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public double getWorkYearSalary() {
        return workYearSalary;
    }

    public void setWorkYearSalary(double workYearSalary) {
        this.workYearSalary = workYearSalary;
    }

    public double getKpi() {
        return kpi;
    }

    public void setKpi(double kpi) {
        this.kpi = kpi;
    }

    public double getSubsitySalary() {
        return subsitySalary;
    }

    public void setSubsitySalary(double subsitySalary) {
        this.subsitySalary = subsitySalary;
    }

    public double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public double getDuductSalary() {
        return duductSalary;
    }

    public void setDuductSalary(double duductSalary) {
        this.duductSalary = duductSalary;
    }

    public double getWithholdSalary() {
        return withholdSalary;
    }

    public void setWithholdSalary(double withholdSalary) {
        this.withholdSalary = withholdSalary;
    }

    public double getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(double realSalary) {
        this.realSalary = realSalary;
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

    public double getTcSalary() {
        return tcSalary;
    }

    public void setTcSalary(double tcSalary) {
        this.tcSalary = tcSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getSocailAmount() {
        return socailAmount;
    }

    public void setSocailAmount(double socailAmount) {
        this.socailAmount = socailAmount;
    }

    public double getFundAmunt() {
        return fundAmunt;
    }

    public void setFundAmunt(double fundAmunt) {
        this.fundAmunt = fundAmunt;
    }

    public double getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(double revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public double getLowestSalaryDifference() {
        return lowestSalaryDifference;
    }

    public void setLowestSalaryDifference(double lowestSalaryDifference) {
        this.lowestSalaryDifference = lowestSalaryDifference;
    }

    public double getTotalWithholdingAmount() {
        return totalWithholdingAmount;
    }

    public void setTotalWithholdingAmount(double totalWithholdingAmount) {
        this.totalWithholdingAmount = totalWithholdingAmount;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getJjSalary() {
        return jjSalary;
    }

    public void setJjSalary(double jjSalary) {
        this.jjSalary = jjSalary;
    }
}