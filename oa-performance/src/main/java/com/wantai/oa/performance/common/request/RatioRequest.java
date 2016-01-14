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
 * @version $Id: RatioRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class RatioRequest extends BaseRequest {

    /** 目标配置对象*/
    String target;

    /** 客户id*/
    String customerId;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
