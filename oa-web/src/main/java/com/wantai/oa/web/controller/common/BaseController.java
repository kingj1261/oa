/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.common;

import com.wantai.oa.biz.shared.result.Status;
import com.wantai.oa.common.lang.enums.ErrorCodeEnum;
import com.wantai.oa.common.lang.exception.CommonException;

/**
 * 公共控制器
 *
 * @author maping.mp
 * @version $Id: BaseController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BaseController {

    /** 数据key*/
    public static final String KEY = "data";

    /**
     * 在回调中执行业务代码
     * @param callback      业务回调
     * @return              结果对象
     */
    protected Status execute(ControllerCallback callback) {
        Status status = new Status();
        try {
            callback.doWithStatus(status);
        } catch (Exception e) {
            status.setSuccess(false);
            if (e instanceof CommonException) {
                CommonException ce = (CommonException) e;
                ErrorCodeEnum errorCode = ce.getErrorCode();
                if (errorCode != null) {
                    status.setErrorCode(errorCode.getCode());
                    status.setErrorMessage(errorCode.getMessage());
                }
            } else {
                status.setErrorCode(e.getMessage());
                status.setErrorMessage(e.getMessage());
            }
        }
        return status;
    }

    protected String getDataKey() {
        return KEY;
    }

}
