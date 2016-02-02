/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.salary;

import java.math.BigDecimal;
import java.util.Date;

public class OaSalaryDetails {
    /* INTEGER(10)-逻辑主键 */
    private Integer    id;

    /* VARCHAR(32)-公司码 */
    private String     companyCode;

    /* INTEGER(10)-公司id */
    private Integer    companyId;

    /* VARCHAR(32)-客户id */
    private String     customerId;

    /* TIMESTAMP(19)-绩效指标设置开始时间 */
    private Date       startTime;

    /* TIMESTAMP(19)-绩效指标设置结束时间 */
    private Date       endTime;

    /* DECIMAL(9)-基本工资 */
    private BigDecimal basicSalary;

    /* DECIMAL(9)-星级工资 */
    private BigDecimal startSalary;

    /* DECIMAL(9)-保底工资 */
    private BigDecimal lowestSalary;

    /* DECIMAL(9)-工龄工资 */
    private BigDecimal workYearsSalary;

    /* DECIMAL(9)-对赌金额 */
    private BigDecimal betAmount;

    /* VARCHAR(12)-单位：币种  元-人民币（156) */
    private String     currency;

    /* DECIMAL(9)-岗位奖金 */
    private BigDecimal gwjj;

    /* DECIMAL(9)-岗位提成 */
    private BigDecimal gwtc;

    /* DECIMAL(9)-考核绩效 */
    private BigDecimal ratioAmount;

    /* DECIMAL(9)-补贴金额 */
    private BigDecimal subsityAmount;

    /* DECIMAL(9)-奖金 */
    private BigDecimal bonusAmount;

    /* DECIMAL(9)-扣款金额 */
    private BigDecimal deductAmount;

    /* DECIMAL(9)-代扣金额 */
    private BigDecimal withholdAmount;

    /* DECIMAL(9)-社保缴存金额 */
    private BigDecimal socailAmount;

    /* DECIMAL(9)-公积金缴存金额 */
    private BigDecimal fundAmount;

    /* DECIMAL(9)-缴存个税 */
    private BigDecimal revenueAmount;

    /* DECIMAL(9)-保底工资差额 */
    private BigDecimal lowestSalaryDifference;

    /* DECIMAL(9)-应发工资 */
    private BigDecimal grossSalary;

    /* DECIMAL(9)-代扣款合计 */
    private BigDecimal totalWithholdingAmount;

    /* DECIMAL(9)-实发工资 */
    private BigDecimal netSalary;

    /* VARCHAR(256)-备注 */
    private String     memo;

    /* TIMESTAMP(19)-创建日期 */
    private Date       gmtCreate;

    /* TIMESTAMP(19)-最后修改日期 */
    private Date       gmtModified;

    /* VARCHAR(32)-操作员 */
    private String     operator;

    /* VARCHAR(32)-最后一次修改日期 */
    private String     lastModifiedOeprator;

    /* getter of attribute id */
    public Integer getId() {
        return id;
    }

    /* setter of attribute id */
    public void setId(Integer id) {
        this.id = id;
    }

    /* getter of attribute companyCode */
    public String getCompanyCode() {
        return companyCode;
    }

    /* setter of attribute companyCode */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /* getter of attribute companyId */
    public Integer getCompanyId() {
        return companyId;
    }

    /* setter of attribute companyId */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /* getter of attribute customerId */
    public String getCustomerId() {
        return customerId;
    }

    /* setter of attribute customerId */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /* getter of attribute startTime */
    public Date getStartTime() {
        return startTime;
    }

    /* setter of attribute startTime */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /* getter of attribute endTime */
    public Date getEndTime() {
        return endTime;
    }

    /* setter of attribute endTime */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /* getter of attribute basicSalary */
    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    /* setter of attribute basicSalary */
    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    /* getter of attribute startSalary */
    public BigDecimal getStartSalary() {
        return startSalary;
    }

    /* setter of attribute startSalary */
    public void setStartSalary(BigDecimal startSalary) {
        this.startSalary = startSalary;
    }

    /* getter of attribute lowestSalary */
    public BigDecimal getLowestSalary() {
        return lowestSalary;
    }

    /* setter of attribute lowestSalary */
    public void setLowestSalary(BigDecimal lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    /* getter of attribute workYearsSalary */
    public BigDecimal getWorkYearsSalary() {
        return workYearsSalary;
    }

    /* setter of attribute workYearsSalary */
    public void setWorkYearsSalary(BigDecimal workYearsSalary) {
        this.workYearsSalary = workYearsSalary;
    }

    /* getter of attribute betAmount */
    public BigDecimal getBetAmount() {
        return betAmount;
    }

    /* setter of attribute betAmount */
    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    /* getter of attribute currency */
    public String getCurrency() {
        return currency;
    }

    /* setter of attribute currency */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /* getter of attribute gwjj */
    public BigDecimal getGwjj() {
        return gwjj;
    }

    /* setter of attribute gwjj */
    public void setGwjj(BigDecimal gwjj) {
        this.gwjj = gwjj;
    }

    /* getter of attribute gwtc */
    public BigDecimal getGwtc() {
        return gwtc;
    }

    /* setter of attribute gwtc */
    public void setGwtc(BigDecimal gwtc) {
        this.gwtc = gwtc;
    }

    /* getter of attribute ratioAmount */
    public BigDecimal getRatioAmount() {
        return ratioAmount;
    }

    /* setter of attribute ratioAmount */
    public void setRatioAmount(BigDecimal ratioAmount) {
        this.ratioAmount = ratioAmount;
    }

    /* getter of attribute subsityAmount */
    public BigDecimal getSubsityAmount() {
        return subsityAmount;
    }

    /* setter of attribute subsityAmount */
    public void setSubsityAmount(BigDecimal subsityAmount) {
        this.subsityAmount = subsityAmount;
    }

    /* getter of attribute bonusAmount */
    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    /* setter of attribute bonusAmount */
    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    /* getter of attribute deductAmount */
    public BigDecimal getDeductAmount() {
        return deductAmount;
    }

    /* setter of attribute deductAmount */
    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }

    /* getter of attribute withholdAmount */
    public BigDecimal getWithholdAmount() {
        return withholdAmount;
    }

    /* setter of attribute withholdAmount */
    public void setWithholdAmount(BigDecimal withholdAmount) {
        this.withholdAmount = withholdAmount;
    }

    /* getter of attribute socailAmount */
    public BigDecimal getSocailAmount() {
        return socailAmount;
    }

    /* setter of attribute socailAmount */
    public void setSocailAmount(BigDecimal socailAmount) {
        this.socailAmount = socailAmount;
    }

    /* getter of attribute fundAmount */
    public BigDecimal getFundAmount() {
        return fundAmount;
    }

    /* setter of attribute fundAmount */
    public void setFundAmount(BigDecimal fundAmount) {
        this.fundAmount = fundAmount;
    }

    /* getter of attribute revenueAmount */
    public BigDecimal getRevenueAmount() {
        return revenueAmount;
    }

    /* setter of attribute revenueAmount */
    public void setRevenueAmount(BigDecimal revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    /* getter of attribute lowestSalaryDifference */
    public BigDecimal getLowestSalaryDifference() {
        return lowestSalaryDifference;
    }

    /* setter of attribute lowestSalaryDifference */
    public void setLowestSalaryDifference(BigDecimal lowestSalaryDifference) {
        this.lowestSalaryDifference = lowestSalaryDifference;
    }

    /* getter of attribute grossSalary */
    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    /* setter of attribute grossSalary */
    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    /* getter of attribute totalWithholdingAmount */
    public BigDecimal getTotalWithholdingAmount() {
        return totalWithholdingAmount;
    }

    /* setter of attribute totalWithholdingAmount */
    public void setTotalWithholdingAmount(BigDecimal totalWithholdingAmount) {
        this.totalWithholdingAmount = totalWithholdingAmount;
    }

    /* getter of attribute netSalary */
    public BigDecimal getNetSalary() {
        return netSalary;
    }

    /* setter of attribute netSalary */
    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    /* getter of attribute memo */
    public String getMemo() {
        return memo;
    }

    /* setter of attribute memo */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /* getter of attribute gmtCreate */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /* setter of attribute gmtCreate */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /* getter of attribute gmtModified */
    public Date getGmtModified() {
        return gmtModified;
    }

    /* setter of attribute gmtModified */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /* getter of attribute operator */
    public String getOperator() {
        return operator;
    }

    /* setter of attribute operator */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /* getter of attribute lastModifiedOeprator */
    public String getLastModifiedOeprator() {
        return lastModifiedOeprator;
    }

    /* setter of attribute lastModifiedOeprator */
    public void setLastModifiedOeprator(String lastModifiedOeprator) {
        this.lastModifiedOeprator = lastModifiedOeprator;
    }
}