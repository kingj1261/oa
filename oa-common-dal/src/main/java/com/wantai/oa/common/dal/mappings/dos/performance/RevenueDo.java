/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

/**
 * 个税配置对象
 *
 * @author maping.mp
 * @version $Id: RevenueDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class RevenueDo extends BaseDo {

    /** 区间最小值*/
    private String fromValue;

    /** 区间最大值*/
    private String toValue;

    /** 税率*/
    private String ratio;

    /** 速算扣除数*/
    private String deducts;

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
