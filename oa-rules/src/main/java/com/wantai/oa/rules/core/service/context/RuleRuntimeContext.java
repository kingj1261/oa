/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.context;

import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.common.util.SpringContextHolder;
import com.wantai.oa.performance.common.ConfigService;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 规则引擎运行时上下文
 * @author maping.mp
 * @version $Id: RuleRuntimeContext.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class RuleRuntimeContext implements Serializable {

    /** 公司码*/
    private String       companyCode;

    /** 公司id*/
    private String       companyId;

    /** 当前公司下所有规则对象 */
    private List<RuleDo> rules = new ArrayList<>();

    public void addRule(RuleDo context) {
        rules.add(context);
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getConfigValue(String bizItem, String bizEvent, String value) {
        ApplicationContext context = SpringContextHolder.getContext();
        ConfigService configService = context.getBean(ConfigService.class);
        return configService.getConfigValue(companyCode, companyId, bizItem, bizEvent, value);
    }

    public void caclulateRatioDetail(String bizItem, String bizEvent, String value,
                                     String customerId) {
        ConfigService configService = SpringContextHolder.getBean(ConfigService.class);
        String realValue = getConfigValue(bizItem, bizEvent, value);
        configService.addRatioDetail(companyCode, companyId, bizItem, bizEvent, realValue,
            customerId);
    }

    /**
     * 获取基础配置服务
     * @return              配置服务对象
     */
    public ConfigService getConfigService() {
        ApplicationContext context = SpringContextHolder.getContext();
        ConfigService configService = context.getBean(ConfigService.class);
        return configService;
    }

    public List<RuleDo> getRules() {
        return rules;
    }

    public void setRules(List<RuleDo> rules) {
        this.rules = rules;
    }
}
