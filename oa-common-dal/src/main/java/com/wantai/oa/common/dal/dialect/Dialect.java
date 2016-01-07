/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.dialect;

/**
 * 数据库方言
 * @author maping.mp
 * @version $Id: Dialect.java, v 0.1 2015-1-04 下午10:34:12 maping.mp Exp $
 */
public abstract class Dialect {

    /**
     * 获取分页sql
     * @param sql       原始sql
     * @param start     开始记录数
     * @param offset    结束记录数
     * @return          包装后的sql
     */
    public abstract String getLimitString(String sql, int start, int offset);

    /**
     * 方言类型,默认支持mysql
     */
    public enum Type {
        MYSQL
    }
}
