/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.result;

import java.io.Serializable;

/**
 * 通用结果对象
 * @author maping.mp
 * @version $Id: Status.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class Status implements Serializable {

    /** 状态 */
    boolean success = true;

    /** 错误码 */
    String errorCode;

    /** 错误描述*/
    String errorMessage;

    /** 结果对象*/
    Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
