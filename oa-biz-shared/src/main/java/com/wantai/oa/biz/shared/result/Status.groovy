/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.result
/**
 * 通用结果对象
 * @author maping.mp
 * @version $Id: Status.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
class Status implements Serializable {

    /** 状态 */
    boolean success=true;

    /** 错误码 */
    String errorCode;

    /** 错误描述*/
    String errorMessage;

    /** 结果对象*/
    Object data;
}
