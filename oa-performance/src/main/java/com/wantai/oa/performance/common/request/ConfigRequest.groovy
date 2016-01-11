/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.request

import com.wantai.oa.biz.shared.request.BaseRequest
import groovy.transform.TupleConstructor

/**
 * 配置请求(系数设置)请求对象
 * @author maping.mp
 * @version $Id: ConfigRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@TupleConstructor
class ConfigRequest extends BaseRequest{

    /** 子表配置id*/
    Long id;

    Long businessConfigId;

    /** 子事件code*/
    String subEventCode;

    /** 值*/
    String value;

    /** 开始值*/
    String fromValue;

    /** 结束值*/
    String toValue;
}
