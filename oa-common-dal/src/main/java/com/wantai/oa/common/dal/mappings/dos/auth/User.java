/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    Integer      id;

    /**
     * 用户名称
     */
    String       name;

    /**
     * 用户登录名称
     */
    String       loginName;

    /**
     * 登陆密码
     */
    String       password;

    /** 公司编码*/
    String       companyCode = "99999999999";

    /** 公司id*/
    Integer      companyId   = 1;

    /** 用户角色*/
    List<String> roles       = new ArrayList();

    /** 所属部门编号*/
    Integer      departId;

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }
}