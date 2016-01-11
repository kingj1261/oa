/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.fact;

import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;

import java.util.List;

/**
 * 事实服务
 * @author maping.mp
 * @version $Id: FactService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface FactService {

    /**
     * 根据rule定义捞取事实数据
     * @param ruleDo            ruleDO
     * @return                  事实数据集合
     */
    List loadFactDatas(RuleDo ruleDo);
}
