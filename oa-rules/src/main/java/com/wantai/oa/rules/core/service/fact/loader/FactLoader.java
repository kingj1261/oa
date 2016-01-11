/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.fact.loader;

import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;

import java.util.List;

/**
 * 事实数据加载器
 * @author maping.mp
 * @version $Id: FactLoader.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface FactLoader {

    /**
     * 捞取事实数据
     * @param ruleDo        规则定义
     * @return              数据集合
     */
    List load(RuleDo ruleDo);
}
