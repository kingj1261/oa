/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.auth.core;

import com.wantai.oa.auth.service.MenuService;
import com.wantai.oa.biz.shared.service.RoleService;
import com.wantai.oa.biz.shared.service.UserService;
import com.wantai.oa.common.dal.mappings.dos.auth.Menu;
import com.wantai.oa.common.dal.mappings.dos.auth.Role;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.lang.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * OA登陆验证处理逻辑
 *
 * @author maping.mp
 * @version $Id: LoginRealm.java, v 0.1 2015-1-04 下午09:16:49 maping.mp Exp $
 */
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @PostConstruct
    public void initCredentialsMatcher() {
        setCredentialsMatcher(new OaCredentialsMatcher());
    }

    /**
     * 用户当前操作的权限验证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) super.getAvailablePrincipal(principals);
        User user = userService.findByName(userName);
        Collection<Role> roles = roleService.findRolesByUserId(user.getId());
        Collection<Menu> menus = menuService.findMenusByUserRoleIdList(roles.stream()
            .map(role -> role.getId()).collect(Collectors.toList()));
        UserAuthorization userAuthorization = new UserAuthorization();
        userAuthorization.setUserRoles(roles);
        userAuthorization.setUserMenus(menus);
        SecurityUtils.getSubject().getSession().setAttribute(Constants.MENU, menus);
        return userAuthorization;
    }

    /**
     * 用户登陆验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
                                                                                                 throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByName(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }

        //使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), user.getName());
    }
}
