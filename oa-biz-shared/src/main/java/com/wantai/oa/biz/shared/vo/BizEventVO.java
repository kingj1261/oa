/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 业务事件VO
 *
 * @author maping.mp
 * @version $Id: BizEventVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BizEventVO implements Serializable {

    /** 配置id*/
    Long                configId;

    /** 业务事项编号*/
    String              bizItem;

    /**
     * 业务事件编号
     */
    String              bizEvent;

    /**
     * 业务事项名称
     */
    String              bizEventName;

    /**
     * 排序
     */
    int                 order;

    /** 子表配置*/
    List<SubBizEventVO> subEventList;

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

    public List<SubBizEventVO> getSubEventList() {
        return subEventList;
    }

    public void setSubEventList(List<SubBizEventVO> subEventList) {
        this.subEventList = subEventList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BizEventVO eventVO = (BizEventVO) o;

        return bizEvent.equals(eventVO.bizEvent);

    }

    @Override
    public int hashCode() {
        return bizEvent.hashCode();
    }
}
