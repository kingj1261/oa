/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.util;

import org.apache.log4j.Logger;

/**
 * 日志工具类
 * @author maping.mp
 * @version $Id: LoggerUtil.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public final class LoggerUtil {

    /**
     * 打印info日志
     * @param logger            日志
     * @param messages          日志消息
     */
    public static void info(Logger logger, Object... messages) {
        StringBuilder sb = new StringBuilder();
        if (logger.isInfoEnabled()) {
            for (Object message : messages) {
                sb.append(String.valueOf(message));
            }
            logger.info(sb.toString());
        }
    }

    /**
     * 打印error日志
     * @param logger            日志
     */
    public static void caughtException(Logger logger, Exception e) {
        logger.info(e);
    }
}
