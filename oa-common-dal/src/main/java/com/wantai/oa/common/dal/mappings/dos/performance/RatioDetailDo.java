/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

import java.util.Date;

/**
 * 绩效计算流水do对象
 *
 * @author maping.mp
 * @version $Id: RatioDetailDo.java, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class RatioDetailDo extends BaseDo {

    /**
     * 配置类型
     */
    String configType;

    /**
     * 业务事项
     */
    String bizItem;

    /**
     * 业务事件
     */
    String bizEvent;

    /**
     * 用户id
     */
    String customerId;

    /**
     * 值
     */
    String value;

    /**
     * 单位
     */
    String unit;

    /** 次数*/
    int    count     = 1;

    /** 总值*/
    double total;

    /** 外部单据日期*/
    Date   outBizDate;
    /**
     * 开始日期
     */
    Date   startTime = new Date();

    /**
     * 结束日期
     */
    Date   endTime   = new Date();

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOutBizDate() {
        return outBizDate;
    }

    public void setOutBizDate(Date outBizDate) {
        this.outBizDate = outBizDate;
    }
}
