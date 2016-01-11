package com.wantai.oa.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试公共类
 * Created by mapingmp on 16/1/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath*:spring/*.xml",
                                   "classpath:shiro-auth.xml" })
public class BaseTest extends Assert {

    /** 日志*/
    protected Logger logger = Logger.getLogger(getClass());
}
