/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 岗位绩效请求(系数设置)请求对象
 *
 * @author maping.mp
 * @version $Id: WorkPerformance.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class WorkPerformance implements Serializable {

    /** 公司编码*/
    private String            companyCode;

    /** 公司id*/
    private String            companyId;

    /** 用户编号*/
    private String            customerId;

    /** 操作员*/
    private String            operator;

    /** 基本工资*/
    private double            basicSalary    = 0;

    /** 保底工资*/
    private double            lowestSalary   = 0;

    /** 星级工资*/
    private double            starSalary     = 0;

    /** 每月绩效工资*/
    private double            monthSalary    = 0;

    /** 最大每月绩效工资*/
    private double            maxMonthSalary = 0;

    /** 考核指标列表*/
    private List<BizConfigVO> bizConfigVOs   = new ArrayList<>();

    /** 对赌金额*/
    private double            betAmount      = 0;

    /** 社保缴纳基本金额*/
    private double            socialBasic    = 0;

    /** 社保缴纳比例*/
    private double            socialPercent  = 0;

    /** 公积金缴纳基本金额*/
    private double            gjjBasic       = 0;

    /** 公积金缴纳比例*/
    private double            gjjPercent     = 0;

    /** 工资计算公式配置*/
    private SalaryFormuaVO    salaryFormuaVO = new SalaryFormuaVO();

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(double lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public double getStarSalary() {
        return starSalary;
    }

    public void setStarSalary(double starSalary) {
        this.starSalary = starSalary;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public double getMaxMonthSalary() {
        return maxMonthSalary;
    }

    public void setMaxMonthSalary(double maxMonthSalary) {
        this.maxMonthSalary = maxMonthSalary;
    }

    public List<BizConfigVO> getBizConfigVOs() {
        return bizConfigVOs;
    }

    public void setBizConfigVOs(List<BizConfigVO> bizConfigVOs) {
        this.bizConfigVOs = bizConfigVOs;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public double getSocialBasic() {
        return socialBasic;
    }

    public void setSocialBasic(double socialBasic) {
        this.socialBasic = socialBasic;
    }

    public double getSocialPercent() {
        return socialPercent;
    }

    public void setSocialPercent(double socialPercent) {
        this.socialPercent = socialPercent;
    }

    public double getGjjBasic() {
        return gjjBasic;
    }

    public void setGjjBasic(double gjjBasic) {
        this.gjjBasic = gjjBasic;
    }

    public double getGjjPercent() {
        return gjjPercent;
    }

    public void setGjjPercent(double gjjPercent) {
        this.gjjPercent = gjjPercent;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public SalaryFormuaVO getSalaryFormuaVO() {
        return salaryFormuaVO;
    }

    public void setSalaryFormuaVO(SalaryFormuaVO salaryFormuaVO) {
        this.salaryFormuaVO = salaryFormuaVO;
    }
}
