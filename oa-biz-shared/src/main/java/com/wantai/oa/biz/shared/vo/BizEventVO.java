/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;

/**
 * 业务事件VO
 *
 * @author maping.mp
 * @version $Id: BizEventVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BizEventVO implements Serializable {

    /**
     * 业务事项编号
     */
    String bizEvent;

    /**
     * 业务事项名称
     */
    String bizEventName;

    /**
     * 排序
     */
    int order;

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
}
