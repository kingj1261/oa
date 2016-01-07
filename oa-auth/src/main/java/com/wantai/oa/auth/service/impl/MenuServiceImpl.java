package com.wantai.oa.auth.service.impl;

import com.wantai.oa.auth.service.MenuService;
import com.wantai.oa.auth.service.UserService;
import com.wantai.oa.common.dal.mappings.dos.auth.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 菜单服务默认实现类
 * Created by mapingmp on 16/1/3.
 */
@Service
public class MenuServiceImpl extends BaseService implements MenuService {

    /** 用户服务*/
    @Autowired
    private UserService userService;

    @Override
    public Collection<Menu> findMenusByUserRoleIdList(Collection<Integer> roleIdList) {
        return null;
    }

    @Override
    public Collection<Menu> findMenusByUserId(Integer userId) {
        return (Collection<Menu>) commonDAO.findAll("Menu.findMenusByUserId", userId);
    }
}
