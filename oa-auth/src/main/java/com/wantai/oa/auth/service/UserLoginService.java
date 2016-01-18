/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.auth.service;

import com.wantai.oa.biz.shared.vo.UserInfoVO;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.lang.exception.AuthException;

/**
 * 用户登陆服务
 * @author maping.mp
 * @version $Id: UserLoginService.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
public interface UserLoginService {

    /**
     * 获取登陆用户信息
     * @param user  用户对象
     * @return      true-登陆成功 false-登陆失败
     */
    boolean login(User user) throws AuthException;

    /**
     * 用户登出
     * @return      true-登出成 false-登出失败
     */
    boolean logout();

    UserInfoVO getUserToRedis(String sid) throws Exception;

    boolean removeOnLinuUser(String sid) throws Exception;

}
