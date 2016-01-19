/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service;

import com.wantai.oa.common.dal.mappings.dos.auth.Role;

import java.util.Collection;

/**
 * 角色服务类
 *
 * @author maping.mp
 * @version $Id: RoleService.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
public interface RoleService {

    /**
     * 根据用户id查询其角色集合
     * @param userId            用户id
     * @return                  角色集合
     */
    Collection<Role> findRolesByUserId(Integer userId);
}
