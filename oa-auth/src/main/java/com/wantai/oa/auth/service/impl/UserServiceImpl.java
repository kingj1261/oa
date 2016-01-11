package com.wantai.oa.auth.service.impl;

import com.wantai.oa.auth.service.UserService;
import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * Created by mapingmp on 16/1/3.
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public User findByName(String name) {
        return (User) commonDAO.selectOne("User.findByName", name);
    }
}
