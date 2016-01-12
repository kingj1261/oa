/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.request;

import com.wantai.oa.biz.shared.request.BaseRequest;

/**
 * 配置请求(系数设置)请求对象
 *
 * @author maping.mp
 * @version $Id: ConfigRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class ConfigRequest extends BaseRequest {

    /**
     * 子表配置id
     */
    Long id;

    Long businessConfigId;

    /**
     * 子事件code
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
}
