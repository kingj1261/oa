/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.service.RoleService;
import com.wantai.oa.biz.shared.service.UserService;
import com.wantai.oa.common.dal.mappings.dos.auth.Role;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户处理接口
 * @author maping.mp
 * @version $Id: UserServiceImpl.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private RoleService roleService;

    @Override
    public User findByName(String name) {
        return (User) commonDAO.selectOne("User.findByName", name);
    }

    @Override
    public List<User> findUsers(String companyCode, String companyId) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        List<User> users = (List<User>) commonDAO.findAll("User.findUsers", parameter);

        users.forEach(user -> {
            Collection<Role> roles = roleService.findRolesByUserId(user.getId());
            user.setRoles(roles.stream().map(role -> role.getCode()).collect(Collectors.toList()));
        });

        return users;
    }
}
