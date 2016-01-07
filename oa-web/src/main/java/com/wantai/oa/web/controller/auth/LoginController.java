/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.auth;

import com.wantai.oa.auth.service.UserLoginService;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.lang.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统登陆控制器
 *
 * @author maping.mp
 * @version $Id: LoginController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Controller
public class LoginController {

    /** 用户服务*/
    @Autowired
    private UserLoginService userLoginService;

    /**
     * 用户登陆控制方法
     * @param user          当前登陆用户对象
     * @return              首页
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginIn(User user) {
        try {
            userLoginService.login(user);
            return "redirect:/system/main";
        } catch (AuthException e) {
            return "redirect:/index";
        }
    }

    /**
     * 用户登出
     * @return              用户登陆结果,success-true登陆成功,success-false登陆失败
     */
    @RequestMapping(value = "system/logout", method = RequestMethod.GET)
    public String logout() {
        userLoginService.logout();
        return "redirect:/index";
    }
}
