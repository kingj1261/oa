/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.common.util.LoggerUtil;
import com.wantai.oa.rules.core.service.RuleService;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * 规则服务实现类
 * @author maping.mp
 * @version $Id: RuleServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class RuleServiceImpl extends BaseService implements RuleService {

    /** 知识库对象*/
    private KnowledgeBase    knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();

    /** builder*/
    private KnowledgeBuilder builder       = KnowledgeBuilderFactory.newKnowledgeBuilder();

    @Override
    public StatefulKnowledgeSession getRuleSession() {
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        return session;
    }

    /**
     * 打印错误日志
     * @param errors        错误对象
     */
    private void showErrors(KnowledgeBuilderErrors errors) {
        for (KnowledgeBuilderError error : errors) {
            LoggerUtil.info(logger, "错误总行数[" + error.getLines().length + "]\n", error.getMessage());
        }
    }

    @PostConstruct
    public synchronized void refreshRules() {
        List<RuleDo> rules = findAllRules();
        if (!CollectionUtils.isEmpty(rules)) {
            for (RuleDo rule : rules) {
                builder.add(ResourceFactory.newByteArrayResource(rule.getRules().getBytes()),
                    ResourceType.DRL);
            }
        }
        if (builder.hasErrors()) {
            showErrors(builder.getErrors());
        }
        knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
    }

    /**
     * 加载所有数据库配置的规则
     * @return                  规则DO对象集合
     */
    @Override
    public List<RuleDo> findAllRules() {
        return (List<RuleDo>) commonDAO.findAll("Rule.findAllRules", new HashMap<>());
    }
}
