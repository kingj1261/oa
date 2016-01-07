/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页面控制器
 *
 * @author maping.mp
 * @version $Id: MainController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Controller
public class MainController {

    @RequestMapping(value = "system/main", method = RequestMethod.GET)
    public String index() {
        return "system/main";
    }
}
