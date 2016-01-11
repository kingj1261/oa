package com.wantai.oa.test.auth;

import com.wantai.oa.auth.core.LoginRealm;
import com.wantai.oa.auth.service.UserLoginService;
import com.wantai.oa.auth.service.UserService;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.lang.enums.ErrorCodeEnum;
import com.wantai.oa.common.lang.exception.AuthException;
import com.wantai.oa.test.BaseTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户服务测试类
 * Created by mapingmp on 16/1/4.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService      userService;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private LoginRealm       loginRealm;

    @Test
    public void testFindByName() {
        User user = userService.findByName("zhangsan");
        assertNotNull(user);
        assertEquals(user.getLoginName(), "zhangsan");
    }

    @Test
    public void testCreatePassword() {
        System.out.println("-----------\n" + new Md5Hash("test").toBase64());
    }

    @Test
    public void testSuccessLogin() {
        User user = new User();
        user.setLoginName("zhangsan");
        user.setPassword("test");
        DefaultSecurityManager sm = new DefaultSecurityManager();
        sm.setRealm(loginRealm);
        ThreadContext.bind(sm);
        boolean result = userLoginService.login(user);
        assertTrue(result);
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getSession());
    }

    @Test
    public void testFailureLogin() {
        User user = new User();
        user.setLoginName("zhangsan22");
        user.setPassword("test");
        DefaultSecurityManager sm = new DefaultSecurityManager();
        sm.setRealm(loginRealm);
        ThreadContext.bind(sm);
        try {
            userLoginService.login(user);
        } catch (AuthException ae) {
            assertTrue(ae.getErrorCode() == ErrorCodeEnum.LOGIN_ERROR_USER_NOT_EXISTS);
        }

        user.setLoginName("zhangsan");
        user.setPassword("test11");
        try {
            userLoginService.login(user);
        } catch (AuthException ae) {
            assertTrue(ae.getErrorCode() == ErrorCodeEnum.LOGIN_ERROR_USER_PASSWORD_INVALID);
        }
    }

}
