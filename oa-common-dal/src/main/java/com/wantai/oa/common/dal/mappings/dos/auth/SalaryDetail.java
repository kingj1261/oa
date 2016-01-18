package com.wantai.oa.common.dal.mappings.dos.auth;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Desc: 简要信息
 * Date: 2016-01-16
 * Time: 下午 10:24
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
public class SalaryDetail implements Serializable {
    /** 工资条编号*/
    Long id;
    /** 公司码*/
    String companyCode;
    /** 公司id */
    Integer companyId;
    /** 客户id*/
    String customerId;
    /** 客户名称*/
    String customerName;
    /** 部门名称 */
    String departmentName;
    /** 绩效指标设置开始时间*/
    Date startTime;
    /** 绩效指标设置结束时间*/
    Date endTime;
    /** 基本工资*/
    BigDecimal basicSalary;
    /** 星级工资*/
    BigDecimal startSalary;
    /** 保底工资*/
    BigDecimal lowestSalary;
    /** 工龄工资*/
    BigDecimal workYearsSalary;
    /** 对赌金额*/
    BigDecimal betAmount;
    /** 单位：币种  元-人民币（156)*/
    String currency;
    /** 岗位奖金*/
    BigDecimal gwjj;
    /** 岗位提成*/
    BigDecimal gwtc;
    /** 绩效工资*/
    BigDecimal ratioAmount;
    /** 补贴金额*/
    BigDecimal subsityAmount;
    /** 奖金*/
    BigDecimal bonusAmount;
    /** 扣款金额*/
    BigDecimal deductAmount;
    /** 代扣金额*/
    BigDecimal withholdAmount;
    /** 社保缴存金额*/
    BigDecimal socailAmount;
    /** 公积金缴存金额*/
    BigDecimal fundAmount;
    /** 缴存个税*/
    BigDecimal revenueAmount;
    /** 备注*/
    String memo;
    /** 创建日期*/
    Date gmtCreate;
    /** 最后修改日期*/
    Date gmtModified;
    /** 操作员*/
    String operator;
    /** 最后一次修改操作员*/
    String last_modified_oeprator;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(BigDecimal startSalary) {
        this.startSalary = startSalary;
    }

    public BigDecimal getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(BigDecimal lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public BigDecimal getWorkYearsSalary() {
        return workYearsSalary;
    }

    public void setWorkYearsSalary(BigDecimal workYearsSalary) {
        this.workYearsSalary = workYearsSalary;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getGwjj() {
        return gwjj;
    }

    public void setGwjj(BigDecimal gwjj) {
        this.gwjj = gwjj;
    }

    public BigDecimal getGwtc() {
        return gwtc;
    }

    public void setGwtc(BigDecimal gwtc) {
        this.gwtc = gwtc;
    }

    public BigDecimal getRatioAmount() {
        return ratioAmount;
    }

    public void setRatioAmount(BigDecimal ratioAmount) {
        this.ratioAmount = ratioAmount;
    }

    public BigDecimal getSubsityAmount() {
        return subsityAmount;
    }

    public void setSubsityAmount(BigDecimal subsityAmount) {
        this.subsityAmount = subsityAmount;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public BigDecimal getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }

    public BigDecimal getWithholdAmount() {
        return withholdAmount;
    }

    public void setWithholdAmount(BigDecimal withholdAmount) {
        this.withholdAmount = withholdAmount;
    }

    public BigDecimal getSocailAmount() {
        return socailAmount;
    }

    public void setSocailAmount(BigDecimal socailAmount) {
        this.socailAmount = socailAmount;
    }

    public BigDecimal getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(BigDecimal fundAmount) {
        this.fundAmount = fundAmount;
    }

    public BigDecimal getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(BigDecimal revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLast_modified_oeprator() {
        return last_modified_oeprator;
    }

    public void setLast_modified_oeprator(String last_modified_oeprator) {
        this.last_modified_oeprator = last_modified_oeprator;
    }


}
