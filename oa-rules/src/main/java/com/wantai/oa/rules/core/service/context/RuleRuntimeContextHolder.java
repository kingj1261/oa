/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.context;

import java.io.Serializable;

/**
 * 规则上下文对象
 * @author maping.mp
 * @version $Id: RuleRuntimeContextHolder.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class RuleRuntimeContextHolder implements Serializable {

    /** 当前线程上下文对象*/
    private static final ThreadLocal<RuleRuntimeContext> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 获取当前规则上下文
     * @return
     */
    public static RuleRuntimeContext getContext() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 设置当前规则上下文
     * @param context
     */
    public static void setContext(RuleRuntimeContext context) {
        CONTEXT_HOLDER.set(context);
    }

    /**
     * 清除当前上下文
     */
    public static void clear() {
        CONTEXT_HOLDER.set(null);
        CONTEXT_HOLDER.remove();
    }

}
