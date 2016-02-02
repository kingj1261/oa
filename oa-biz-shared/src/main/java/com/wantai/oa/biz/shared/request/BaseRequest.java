/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.request;

import java.io.Serializable;

/**
 * 公共请求基类
 *
 * @author maping.mp
 * @version $Id: BaseRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BaseRequest implements Serializable {

    /** 业务配置id*/
    Long    businessConfigId;

    /** 业务配置id*/
    String  value;

    /** 开始值*/
    String  fromValue;

    /** 结束值*/
    String  toValue;

    /** 单位*/
    String  unit;

    /** 子事件编号*/
    String  subEventCode;

    /** 子事件名称*/
    String  subEventCodeName;

    /** 目标配置对象*/
    String  target;

    /** 客户id*/
    String  customerId;

    /** 操作员*/
    String  operator;

    boolean enable = false;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getBusinessConfigId() {
        return businessConfigId;
    }

    public void setBusinessConfigId(Long businessConfigId) {
        this.businessConfigId = businessConfigId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFromValue() {
        return fromValue;
    }

    public void setFromValue(String fromValue) {
        this.fromValue = fromValue;
    }

    public String getToValue() {
        return toValue;
    }

    public void setToValue(String toValue) {
        this.toValue = toValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSubEventCode() {
        return subEventCode;
    }

    public void setSubEventCode(String subEventCode) {
        this.subEventCode = subEventCode;
    }

    public String getSubEventCodeName() {
        return subEventCodeName;
    }

    public void setSubEventCodeName(String subEventCodeName) {
        this.subEventCodeName = subEventCodeName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
