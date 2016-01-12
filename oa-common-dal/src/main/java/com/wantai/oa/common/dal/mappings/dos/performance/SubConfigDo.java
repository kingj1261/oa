/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

/**
 * 子表配置对象
 *
 * @author maping.mp
 * @version $Id: SubConfigDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class SubConfigDo extends ConfigDo {
    /**
     * id
     */
    Long id;

    Long businessConfigId;

    /**
     * 配置类型
     */
    String subEventCode;

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

    /**
     * 是否启用 true-启用 false-不启用
     */
    String memo;

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

    @Override
    public String getValue() {
        return value;
    }

    @Override
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

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String getMemo() {
        return memo;
    }

    @Override
    public void setMemo(String memo) {
        this.memo = memo;
    }
}
