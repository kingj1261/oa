/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.dialect;

/**
 * mysql方言实现器
 *
 * @author maping.mp
 * @version $Id: Dialect.java, v 0.1 2015-1-03 下午10:54:12 maping.mp Exp $
 */
public class MySqlDialect extends Dialect {

    /** 逗号*/
    private static final String DOT = ",";

    @Override
    public String getLimitString(String sql, int start, int offset) {
        StringBuilder sb = new StringBuilder(sql.trim());
        sb.append(" limit ").append(start).append(DOT).append(offset);
        return sb.toString();
    }
}
