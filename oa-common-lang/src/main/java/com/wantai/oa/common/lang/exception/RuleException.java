/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.lang.exception;

import com.wantai.oa.common.lang.enums.ErrorCodeEnum;

/**
 * 规则异常
 * @author maping.mp
 * @version $Id: RuleException.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class RuleException extends CommonException {

    public RuleException(ErrorCodeEnum errorCode) {
        super(errorCode);
    }
}
