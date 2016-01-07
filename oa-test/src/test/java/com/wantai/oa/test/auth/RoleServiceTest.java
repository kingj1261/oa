package com.wantai.oa.test.auth;

import com.wantai.oa.auth.service.RoleService;
import com.wantai.oa.common.dal.mappings.dos.auth.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * 用户角色服务测试类
 * Created by mapingmp on 16/1/4.
 */
public class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindUserRoleById() {
        Collection<Role> roles = roleService.findRolesByUserId(12);
        assertNotNull(roles);
        assertTrue(roles.size() == 1);
        roles.forEach(role -> assertEquals(role.getId(), new Integer(10)));
    }
}
