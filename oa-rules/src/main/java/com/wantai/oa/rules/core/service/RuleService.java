/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service;

import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.List;

/**
 * 规则服务类
 * @author maping.mp
 * @version $Id: RuleService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface RuleService {

    /**
     * 获取规则session
     * @return
     */
    StatefulKnowledgeSession getRuleSession();

    /**
     * 重新加载所有的规则
     */
    void refreshRules();

    /**
     * 加载所有数据库配置的规则
     *
     * @return                  规则DO对象集合
     */
    List<RuleDo> findAllRules();

    /**
     * 加载所有数据库配置的规则
     *
     * @param companyCode       公司code
     * @param companyId         公司id
     * @return                  规则DO对象集合
     */
    List<RuleDo> findAllRulesWithCompany(String companyCode, String companyId);

    /**
     * 触发所有的规则执行器
     *
     * @param companyCode       公司code
     * @param companyId         公司id
     *
     * 该方法将查询所有的规则并根据规则定义的数据进行试算
     */
    void fireAllRules(String companyCode, String companyId);

}
