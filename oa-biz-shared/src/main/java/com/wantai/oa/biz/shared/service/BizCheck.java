/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service;

/**
 * 公共服务回调
 *
 * @author maping.mp
 * @version $Id: BizCheck.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */

@FunctionalInterface
public interface BizCheck {

    /**
     * 业务规则检查
     */
    void bizCheck();
}
