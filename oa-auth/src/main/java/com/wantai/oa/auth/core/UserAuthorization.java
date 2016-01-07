/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.auth.core;

import com.wantai.oa.common.dal.mappings.dos.auth.Menu;
import com.wantai.oa.common.dal.mappings.dos.auth.Role;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 用户验证对象
 *
 * @author maping.mp
 * @version $Id: UserAuthorization.java, v 0.1 2015-1-04 下午09:16:59 maping.mp Exp $
 */
public class UserAuthorization implements AuthorizationInfo {
    /** 用户角色集合*/
    private Collection<Role> userRoles = new ArrayList<>();

    /** 用户菜单集合*/
    private Collection<Menu> userMenus = new ArrayList<>();

    @Override
    public Collection<String> getRoles() {
        Collection<String> roles = new ArrayList<>();
        userRoles.forEach(role -> roles.add(role.getName()));
        return roles;
    }

    @Override
    public Collection<String> getStringPermissions() {
        return null;
    }

    @Override
    public Collection<Permission> getObjectPermissions() {
        return null;
    }

    public Collection<Menu> getUserMenus() {
        return userMenus;
    }

    public void setUserMenus(Collection<Menu> userMenus) {
        this.userMenus = userMenus;
    }

    public Collection<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
