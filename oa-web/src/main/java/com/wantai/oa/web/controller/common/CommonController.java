/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.common;

import com.wantai.oa.biz.shared.result.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共控制器
 *
 * @author maping.mp
 * @version $Id: CommonController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Controller
public class CommonController {

    /**
     * 错误异常拦截处理
     * @param e             异常
     * @return              错误对象
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Status handleException(Exception e) {
        Status status = new Status();
        status.setSuccess(false);
        status.setErrorCode("Unkown");
        status.setErrorMessage(e.getMessage());
        return status;
    }
}
