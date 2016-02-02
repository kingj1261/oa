package com.wantai.oa.common.dal.mappings.dos.performance;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Desc: 简要信息
 * Date: 2016-01-22
 * Time: 上午 9:58
 * author: liuyuxiang
 * Created by IntelliJ IDEA.
 */
public class PerformanceDetail {
    /** 逻辑主键 */
    Long id;
    /** 公司码 */
    String companyCode;
    /** 公司ID */
    Integer companyId;
    /** 员工ID */
    String customerId;
    /** 绩效指标设置开始时间 */
    Date startTime;
    /** 绩效指标设置结束时间 */
    Date endTime;
    /** 配置类型 绩效系数-jxxs 岗位奖金-gwjj 岗位提成-gwtc */
    String configType;
    /** 业务事项 */
    String bizItem;
    /** 业务事件 */
    String bizEvent;
    /** 实际值 */
    String value;
    /** 值单位 元-人民币（156） */
    String unit;
    /** 次数 绩效系数计算时默认为1 */
    Integer count;
    /** 总值 */
    BigDecimal total;
    /** 外部事件发生时间（奖金、补贴、扣款、其它代扣) */
    Date outBizDate;
    /** 备注 */
    String memo;
    /** 创建日期 */
    String gmtCreate;
    /** 最后修改日期 */
    String gmtModified;
    /** 操作员 */
    String operator;
    /** 最后一次修改日期 */
    String lastModifiedOeprator;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

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

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getBizItem() {
        return bizItem;
    }

    public void setBizItem(String bizItem) {
        this.bizItem = bizItem;
    }

    public String getBizEvent() {
        return bizEvent;
    }

    public void setBizEvent(String bizEvent) {
        this.bizEvent = bizEvent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getOutBizDate() {
        return outBizDate;
    }

    public void setOutBizDate(Date outBizDate) {
        this.outBizDate = outBizDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLastModifiedOeprator() {
        return lastModifiedOeprator;
    }

    public void setLastModifiedOeprator(String lastModifiedOeprator) {
        this.lastModifiedOeprator = lastModifiedOeprator;
    }
}
