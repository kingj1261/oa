/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.lang.exception;

import com.wantai.oa.common.lang.enums.ErrorCodeEnum;

/**
 * 公共异常
 * @author maping.mp
 * @version $Id: CommonException.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class CommonException extends RuntimeException {

    /** 错误码*/
    protected ErrorCodeEnum errorCode;

    public CommonException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCodeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }
}
