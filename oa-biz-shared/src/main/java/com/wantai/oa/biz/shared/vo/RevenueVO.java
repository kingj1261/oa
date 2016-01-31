/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;

/**
 * 税率VO
 *
 * @author maping.mp
 * @version $Id: RevenueVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class RevenueVO implements Serializable {

    /** 序号 */
    private int    order;

    /** 区间最小值*/
    private String fromValue = "0";

    /** 区间最大值*/
    private String toValue;

    /** 税率*/
    private String ratio;

    /** 速算扣除数*/
    private String deducts;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getDeducts() {
        return deducts;
    }

    public void setDeducts(String deducts) {
        this.deducts = deducts;
    }
}
