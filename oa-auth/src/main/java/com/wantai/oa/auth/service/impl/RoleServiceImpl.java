package com.wantai.oa.auth.service.impl;

import com.wantai.oa.auth.service.RoleService;
import com.wantai.oa.common.dal.mappings.dos.auth.Role;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 用户服务实现类
 * Created by mapingmp on 16/1/3.
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {
    @Override
    public Collection<Role> findRolesByUserId(Integer userId) {
        return (Collection<Role>) commonDAO.findAll("Role.findRolesByUserId", userId + "");
    }
}
