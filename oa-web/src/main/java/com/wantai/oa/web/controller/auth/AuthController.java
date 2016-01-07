/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.auth;

import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.auth.service.MenuService;
import com.wantai.oa.common.dal.mappings.dos.auth.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 登陆相关控制器
 *
 * @author maping.mp
 * @version $Id: AuthController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class AuthController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取当前登陆用户的菜单列表
     * @return
     */
    @RequestMapping(value = "system/menu/list", method = RequestMethod.GET)
    public Collection<Menu> getMenusOfCurrentUser() {
        return menuService.findMenusByUserId(UserHolder.getUser().getId());
    }
}
