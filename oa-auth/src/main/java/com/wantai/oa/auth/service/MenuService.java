/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.auth.service;

import com.wantai.oa.common.dal.mappings.dos.auth.Menu;

import java.util.Collection;

/**
 * 菜单服务类
 *
 * @author maping.mp
 * @version $Id: MenuService.java, v 0.1 2015-1-04 下午09:26:59 maping.mp Exp $
 */
public interface MenuService {
    /**
     * 根据用户角色编号批量查询菜单配置
     * @param roleIdList            用户角色编号
     * @return                      菜单集合
     */
    Collection<Menu> findMenusByUserRoleIdList(Collection<Integer> roleIdList);

    /**
     * 根据用户角色编号批量查询菜单配置
     * @param userId                用户编号
     * @return                      菜单集合
     */
    Collection<Menu> findMenusByUserId(Integer userId);
}
