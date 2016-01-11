/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service;

/**
 * 可执行函数接口
 *
 * @author maping.mp
 * @version $Id: Executable.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */

@FunctionalInterface
public interface Executable<T> {
    void execute(T request);
}