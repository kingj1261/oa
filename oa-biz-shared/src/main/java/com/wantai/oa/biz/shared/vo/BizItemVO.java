/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务事项VO
 *
 * @author maping.mp
 * @version $Id: BizItemVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */

public class BizItemVO implements Serializable {

    /**
     * 业务事项编号
     */
    String              bizItem;

    /**
     * 业务事项名称
     */
    String              bizItemName;

    /**
     * 排序
     */
    int                 order;

    /**
     * 备注
     */
    String              memo;
    /**
     * 业务扩展字段
     */
    Map<String, Object> context   = new HashMap<>();

    /**
     * 业务事件集合
     */
    List<BizEventVO>    bizEvents = new ArrayList<>();

    public String getBizItem() {
        return bizItem;
    }

    public void setBizItem(String bizItem) {
        this.bizItem = bizItem;
    }

    public String getBizItemName() {
        return bizItemName;
    }

    public void setBizItemName(String bizItemName) {
        this.bizItemName = bizItemName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<BizEventVO> getBizEvents() {
        return bizEvents;
    }

    public void setBizEvents(List<BizEventVO> bizEvents) {
        this.bizEvents = bizEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BizItemVO itemVO = (BizItemVO) o;

        return bizItem.equals(itemVO.bizItem);

    }

    @Override
    public int hashCode() {
        return bizItem.hashCode();
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
