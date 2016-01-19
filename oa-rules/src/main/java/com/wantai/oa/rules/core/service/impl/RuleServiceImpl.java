/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.service.UserService;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.common.util.LoggerUtil;
import com.wantai.oa.rules.core.service.RuleService;
import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;
import com.wantai.oa.rules.core.service.context.RuleRuntimeContextHolder;
import com.wantai.oa.rules.core.service.fact.FactService;
import org.apache.commons.lang3.StringUtils;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /** 事实数据服务对象*/
    @Autowired
    private FactService      factService;

    /** 用户服务对象*/
    @Autowired
    private UserService      userService;

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

    @Override
    public List<RuleDo> findAllRules() {
        List<RuleDo> rules = (List<RuleDo>) commonDAO.findAll("Rule.findAllRules", new HashMap<>());
        fillRuleContext(rules);
        return rules;
    }

    /**
     * 填充规则上下文属性
     * @param rules         规则集合
     */
    private void fillRuleContext(List<RuleDo> rules) {
        rules.forEach(rule -> {
            if (StringUtils.isNotBlank(rule.getContext())) {
                Map<String, Object> attributes = new HashMap();
                JSONObject data = JSON.parseObject(rule.getContext());
                if (data != null && data.size() > 0) {
                    for (String key : data.keySet()) {
                        attributes.put(key, data.get(key));
                    }
                }
                rule.setData(attributes);
            }
        });
    }

    @Override
    public List<RuleDo> findAllRulesWithCompany(String companyCode, String companyId) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        List<RuleDo> rules = (List<RuleDo>) commonDAO.findAll("Rule.findAllRulesWithCompany",
            parameter);
        fillRuleContext(rules);
        return rules;
    }

    @Override
    public void fireAllRules(String companyCode, String companyId) {
        try {
            List<RuleDo> ruleDoList = findAllRulesWithCompany(companyCode, companyId);
            if (CollectionUtils.isEmpty(ruleDoList)) {
                LoggerUtil.info(logger, "当前公司码[" + companyCode + "],公司id[" + companyId
                                        + "]未配置规则,不进行计算");
                return;
            }

            //加载所有规则到运行时中
            RuleRuntimeContext context = new RuleRuntimeContext();
            context.setCompanyCode(companyCode);
            context.setCompanyId(companyId);
            ruleDoList.forEach(rule -> context.addRule(rule));

            //加载上下文到session中
            StatefulKnowledgeSession session = getRuleSession();
            session.setGlobal("context", context);

            //把当前公司所有的用户加载到工作内存中
            loadAllUsers2WorkMemory(session, companyCode, companyId);

            //加载所有rule的事实数据到内存中
            context.getRules().forEach(rule -> {
                loadFactByRule(session, rule);
            });

            //触发规则
            session.fireAllRules();

            //释放内存
            session.dispose();
        } catch (Throwable t) {
            throw new RuntimeException("触发当前公司(" + companyCode + "," + companyId + ")", t);
        } finally {
            RuleRuntimeContextHolder.clear();
        }
    }

    /**
     * 加载当前公司所有用户到工作内存中
     * @param session                   drools会话
     * @param companyCode               公司码
     * @param companyId                 公司id
     */
    private void loadAllUsers2WorkMemory(StatefulKnowledgeSession session, String companyCode,
                                         String companyId) {
        List<User> users = userService.findUsers(companyCode, companyId);
        Assert.notEmpty(users, "用户列表不能为空");
        users.forEach(user -> session.insert(user));
    }

    private void loadFactByRule(StatefulKnowledgeSession session, RuleDo rule) {
        try {
            //根据规则定义抽取数据
            List factsList = factService.loadFactDatas(rule);
            if (CollectionUtils.isEmpty(factsList)) {
                LoggerUtil.info(logger, "当前规则id[" + rule.getId() + "]未能加载到数据,不参与规则计算");
                return;
            }
            factsList.forEach(fact -> session.insert(fact));
        } catch (Exception e) {
            LoggerUtil.caughtException(logger, e, "当前规则触发失败");
        }
    }
}
