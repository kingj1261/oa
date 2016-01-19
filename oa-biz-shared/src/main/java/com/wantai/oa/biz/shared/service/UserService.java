/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service;

import com.wantai.oa.common.dal.mappings.dos.auth.User;

import java.util.List;

/**
 * 用户处理接口
 * @author maping.mp
 * @version $Id: UserService.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
public interface UserService {

    /**
     * 根据用户名查找用户,如果用户不存在,抛出LOGIN_ERROR_USER_NOT_EXISTS错误码
     * @param name              用户名称
     * @return                  用户对象
     */
    User findByName(String name);

    /**
     * 查询当前公司下面所有用户信息
     * @param companyCode       公司code
     * @param companyId         公司id
     * @return                  用户列表
     */
    List<User> findUsers(String companyCode, String companyId);
}
