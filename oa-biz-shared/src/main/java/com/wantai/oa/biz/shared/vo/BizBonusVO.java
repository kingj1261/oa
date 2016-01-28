/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;

/**
 * 奖金,提成VO对象
 *
 * @author maping.mp
 * @version $Id: BizBonusVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BizBonusVO implements Serializable {

    /** 配置id*/
    Long    configId;

    /** 业务事项编号*/
    String  bizItem;

    /**
     * 业务事件编号
     */
    String  bizEvent;

    /**
     * 业务事项名称
     */
    String  bizEventName;

    /**
     * 排序
     */
    int     order;

    /**
     * 公司值
     */
    String  companyValue = "0";

    /**
     * 个人值
     */
    String  customValue  = "0";

    /**
     * 客户id
     */
    String  customerId;

    /**
     * 是否启用
     */
    boolean enable       = true;

    /**
     * 单位
     */
    String  unit         = "元/次";

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
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

    public String getBizEventName() {
        return bizEventName;
    }

    public void setBizEventName(String bizEventName) {
        this.bizEventName = bizEventName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCompanyValue() {
        return companyValue;
    }

    public void setCompanyValue(String companyValue) {
        this.companyValue = companyValue;
    }

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BizBonusVO eventVO = (BizBonusVO) o;

        return bizEvent.equals(eventVO.bizEvent);

    }

    @Override
    public int hashCode() {
        return bizEvent.hashCode();
    }
}
