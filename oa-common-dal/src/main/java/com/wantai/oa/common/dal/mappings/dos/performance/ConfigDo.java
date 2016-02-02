/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

import java.util.Date;

/**
 * 绩效do对象
 *
 * @author maping.mp
 * @version $Id: ConfigDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class ConfigDo extends BaseDo {

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
     * 业务事项名称
     */
    String bizItemName;

    /**
     * 业务事件名称
     */
    String bizEventName;

    /**
     * 业务事项顺序
     */
    int    bizItemOrder;

    /**
     * 业务事件顺序
     */
    int    bizEventOrder;

    /**
     * 值
     */
    String value;

    /**
     * 单位
     */
    String unit;

    /**
     * 是否启用 true-启用 false-不启用
     */
    String enable;

    /**
     * 目标对象
     */
    String target;

    /**
     * 开始日期
     */
    Date   startTime = new Date();

    /**
     * 结束日期
     */
    Date   endTime   = new Date();

    /**
     * 扩展字段
     * @return
     */
    String context   = "{}";

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

    public String getBizItemName() {
        return bizItemName;
    }

    public void setBizItemName(String bizItemName) {
        this.bizItemName = bizItemName;
    }

    public String getBizEventName() {
        return bizEventName;
    }

    public void setBizEventName(String bizEventName) {
        this.bizEventName = bizEventName;
    }

    public int getBizItemOrder() {
        return bizItemOrder;
    }

    public void setBizItemOrder(int bizItemOrder) {
        this.bizItemOrder = bizItemOrder;
    }

    public int getBizEventOrder() {
        return bizEventOrder;
    }

    public void setBizEventOrder(int bizEventOrder) {
        this.bizEventOrder = bizEventOrder;
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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
