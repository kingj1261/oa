/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.lang.exception;

import com.wantai.oa.common.lang.enums.ErrorCodeEnum;
import org.apache.shiro.authc.AuthenticationException;

/**
 * 登陆异常信息
 *
 * @author maping.mp
 * @version $Id: AuthException.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class AuthException extends AuthenticationException {

    /** 错误码*/
    protected ErrorCodeEnum errorCode;

    public AuthException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }
}
