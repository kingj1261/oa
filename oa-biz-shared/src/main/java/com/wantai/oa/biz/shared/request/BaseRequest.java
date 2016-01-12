/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.request;

import com.wantai.oa.common.lang.enums.ConfigTypeEnum;

import java.io.Serializable;

/**
 * 公共请求基类
 *
 * @author maping.mp
 * @version $Id: BaseRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BaseRequest implements Serializable {
    /**
     * 公司码
     */
    String companyCode;

    /**
     * 公司id
     */
    Long companyId;

    /**
     * 配置类型
     */
    ConfigTypeEnum configType;

    /**
     * 业务事项
     */
    String bizItem;

    /**
     * 业务事件
     */
    String bizEvent;

    /**
     * 值
     */
    String value;

    /**
     * 单位
     */
    String unit;

    /**
     * 备注
     */
    String memo;

    /**
     * 操作员
     */
    String operator;

    /**
     * 最后一次修改操作员
     */
    String lastModifiedOperator;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public ConfigTypeEnum getConfigType() {
        return configType;
    }

    public void setConfigType(ConfigTypeEnum configType) {
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLastModifiedOperator() {
        return lastModifiedOperator;
    }

    public void setLastModifiedOperator(String lastModifiedOperator) {
        this.lastModifiedOperator = lastModifiedOperator;
    }
}
