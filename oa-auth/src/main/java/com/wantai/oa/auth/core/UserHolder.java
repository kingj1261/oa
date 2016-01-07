/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.auth.core;

import com.wantai.oa.common.dal.mappings.dos.auth.User;

/**
 * 用户登陆服务
 *
 * @author maping.mp
 * @version $Id: UserLoginServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public final class UserHolder {

    /** 当前ThreadLocal对象*/
    private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    /**
     * 获取当前登陆用户
     * @return          返回当前用户
     */
    public static User getUser() {
        return userThreadLocal.get();
    }

    /**
     * 设置当前用户
     * @param user      用户对象
     */
    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    /**
     * 移除当前用户
     */
    public static void remove() {
        userThreadLocal.set(null);
    }
}
