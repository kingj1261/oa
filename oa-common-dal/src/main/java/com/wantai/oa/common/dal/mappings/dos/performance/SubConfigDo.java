/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

/**
 * 子表配置对象
 *
 * @author maping.mp
 * @version $Id: SubConfigDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class SubConfigDo extends BaseDo {
    /**
     * id
     */
    Long   id;

    /** 主配置id*/
    Long   businessConfigId;

    /**
     * 配置类型
     */
    String subEventCode;

    /** 子事件名称*/
    String subEventCodeName;

    /** 目标配置对象*/
    String target;

    /** 客户id*/
    String customerId;

    /**
     * 值
     */
    String value;

    /**
     * 开始值
     */
    String fromValue;

    /**
     * 结束值
     */
    String toValue;

    /**
     * 单位
     */
    String unit;

    int    order;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessConfigId() {
        return businessConfigId;
    }

    public void setBusinessConfigId(Long businessConfigId) {
        this.businessConfigId = businessConfigId;
    }

    public String getSubEventCode() {
        return subEventCode;
    }

    public void setSubEventCode(String subEventCode) {
        this.subEventCode = subEventCode;
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

    public String getSubEventCodeName() {
        return subEventCodeName;
    }

    public void setSubEventCodeName(String subEventCodeName) {
        this.subEventCodeName = subEventCodeName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
