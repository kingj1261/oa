/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: SpringContextHolder.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class SpringContextHolder implements ApplicationContextAware {

    /** 上下文对象*/
    private static ApplicationContext context;

    /**
     * 获取上下文
     * @return      上下文对象
     */
    public static ApplicationContext getContext() {
        Assert.notNull(context);
        return context;
    }

    /**
     * 获取指定类型的bean
     * @param type  类型
     * @return
     */
    public static <T> T getBean(Class<T> type) {
        return getContext().getBean(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
