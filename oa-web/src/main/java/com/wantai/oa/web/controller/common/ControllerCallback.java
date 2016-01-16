/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.common;

import com.wantai.oa.biz.shared.result.Status;

/**
 * 公共控制器回调
 *
 * @author maping.mp
 * @version $Id: ControllerCallback.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@FunctionalInterface
public interface ControllerCallback {

    /**
     * 执行回调函数
     * @param status
     */
    void doWithStatus(Status status);
}
