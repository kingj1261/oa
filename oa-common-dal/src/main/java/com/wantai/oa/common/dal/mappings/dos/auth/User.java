/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.auth;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author maping.mp
 * @version $Id: User.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class User implements Serializable {

    /**
     * 用户编号
     */
    Integer id;

    /**
     * 用户名称
     */
    String name;

    /**
     * 用户登录名称
     */
    String loginName;

    /**
     * 登陆密码
     */
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}