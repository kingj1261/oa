/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.listener;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.ServletContextEvent;
import java.io.IOException;
import java.util.Properties;

/**
 * 自定义log4j监听器
 * @author maping.mp
 * @version $Id: CustomLog4jConfigListener.java, v 0.1 2015-1-06 下午10:55:39 maping.mp Exp $
 */
public class CustomLog4jConfigListener extends Log4jConfigListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:common.properties");
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            for (Object key : props.keySet()) {
                System.setProperty(String.valueOf(key), String.valueOf(props.get(key)));
            }
            super.contextInitialized(event);
        } catch (IOException e) {
            throw new RuntimeException("panic initlize log4j error");
        }
    }
}
