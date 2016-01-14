/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 公共请求基类
 *
 * @author maping.mp
 * @version $Id: BaseRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BaseRequest implements Serializable {

    /** 业务配置id*/
    @NotNull(message = "主配置编号id不能为空")
    @Digits(integer = 10, fraction = 0)
    Long   businessConfigId;

    /**
     * 值
     */
    @NotNull(message = "值不能为空")
    @NotEmpty(message = "值不能为空")
    @Digits(integer = 10, fraction = 2)
    String value;

    /**
     * 开始值
     */
    @NotNull(message = "开始值不能为空")
    @NotEmpty(message = "开始值不能为空")
    @Digits(integer = 10, fraction = 2)
    String fromValue;

    /**
     * 结束值
     */
    @NotNull(message = "结束值不能为空")
    @NotEmpty(message = "结束值不能为空")
    @Digits(integer = 10, fraction = 2)
    String toValue;

    /**
     * 单位
     */
    @NotNull(message = "单位不能为空")
    @NotEmpty(message = "单位不能为空")
    String unit;

    String subEventCode;

    String subEventCodeName;

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
}
