/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.auth.service.impl;

import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.auth.service.UserLoginService;
import com.wantai.oa.auth.service.UserService;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.lang.enums.ErrorCodeEnum;
import com.wantai.oa.common.lang.exception.AuthException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登陆服务
 *
 * @author maping.mp
 * @version $Id: UserLoginServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserService userService;

    @Override
    public boolean login(User user) throws AuthenticationException {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(),
            user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserHolder.setUser(userService.findByName(user.getLoginName()));
        } catch (UnknownAccountException uae) {
            throw new AuthException(ErrorCodeEnum.LOGIN_ERROR_USER_NOT_EXISTS);
        } catch (IncorrectCredentialsException ice) {
            throw new AuthException(ErrorCodeEnum.LOGIN_ERROR_USER_PASSWORD_INVALID);
        } finally {
            token.clear();
        }
        return subject.isAuthenticated();
    }

    @Override
    public boolean logout() {
        SecurityUtils.getSubject().logout();
        UserHolder.remove();
        return true;
    }
}
