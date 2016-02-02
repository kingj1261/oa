/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.context;

import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.common.util.LoggerUtil;
import com.wantai.oa.common.util.SpringContextHolder;
import com.wantai.oa.performance.common.ConfigService;
import org.apache.log4j.Logger;
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
    private List<RuleDo> rules  = new ArrayList<>();

    /** 日志*/
    private Logger       logger = Logger.getLogger(RuleRuntimeContext.class);

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

    public String getConfigValue(String configType, String bizItem, String bizEvent, String value,
                                 String customerId) {
        ApplicationContext context = SpringContextHolder.getContext();
        ConfigService configService = context.getBean(ConfigService.class);
        return configService.getConfigValue(configType, companyCode, companyId, bizItem, bizEvent,
            value, customerId);
    }

    public void caclulateRatioDetail(String configType, String bizItem, String bizEvent,
                                     String value, String customerId) {

        LoggerUtil.info(logger, "当前类型为[" + configType + "],bizItem=[" + bizItem + "],bizEvent=["
                                + bizEvent + "],当前用户id[" + customerId + "],实际值为[" + value + "]");
        ConfigService configService = SpringContextHolder.getBean(ConfigService.class);
        String realValue = getConfigValue(configType, bizItem, bizEvent, value, customerId);
        configService.addRatioDetail(configType, companyCode, companyId, bizItem, bizEvent,
            realValue, customerId);
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
