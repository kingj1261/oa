/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;

/**
 * 子事件VO对象
 *
 * @author maping.mp
 * @version $Id: SubBizEventVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class SubBizEventVO implements Serializable {

    Long   id;

    Long   businessConfigId;

    String subEventCode;

    String subEventCodeName;

    String fromValue;

    String toValue;

    String value;

    String unit;

    String enable;

    int    order;

    String target;

    String customerId;

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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessConfigId() {
        return businessConfigId;
    }

    public void setBusinessConfigId(Long businessConfigId) {
        this.businessConfigId = businessConfigId;
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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SubBizEventVO that = (SubBizEventVO) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
