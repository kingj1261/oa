/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.util;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 对象工具类
 *
 * @author maping.mp
 * @version $Id: ObjectUtils.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public final class ObjectUtils {

    /**
     * 拷贝并返回目标对象
     * @param src           原对象
     * @param dest          目标对象
     * @return              目标对象
     */
    public static Object copy(Object src, Object dest) {
        try {
            PropertyUtils.copyProperties(src, dest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dest;
    }
}
