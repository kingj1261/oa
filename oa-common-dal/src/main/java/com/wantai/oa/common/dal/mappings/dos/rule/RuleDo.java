/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.rule;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

import java.util.HashMap;
import java.util.Map;

/**
 * 规则do对象
 *
 * @author maping.mp
 * @version $Id: RuleDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class RuleDo extends BaseDo {

    /**
     * 配置类型
     */
    String                      configType;

    /**
     * 业务事项
     */
    String                      bizItem;

    /**
     * 业务事件
     */
    String                      bizEvent;

    /**
     * 规则内容
     */
    String                      rules;

    /**
     * 数据抽取器
     */
    String                      dataExtractor;

    /**
     * 数据抽取脚本
     */
    String                      dataExtractShell;

    String                      context;

    /** 数据容器*/
    private Map<String, Object> data = new HashMap<>();

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getBizItem() {
        return bizItem;
    }

    public void setBizItem(String bizItem) {
        this.bizItem = bizItem;
    }

    public String getBizEvent() {
        return bizEvent;
    }

    public void setBizEvent(String bizEvent) {
        this.bizEvent = bizEvent;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getDataExtractor() {
        return dataExtractor;
    }

    public void setDataExtractor(String dataExtractor) {
        this.dataExtractor = dataExtractor;
    }

    public String getDataExtractShell() {
        return dataExtractShell;
    }

    public void setDataExtractShell(String dataExtractShell) {
        this.dataExtractShell = dataExtractShell;
    }

    /**
     * 添加属性
     * @param key           属性名称
     * @param value         属性值
     */
    public void addAttribute(String key, Object value) {
        data.put(key, value);
    }

    /**
     * 获取属性对象
     * @param key           属性名称
     * @return              属性值
     */
    public Object getAttribute(String key) {
        return data.get(key);
    }

    /**
     * 获取string数据
     * @param key           属性名称
     * @return              属性值
     */
    public String getString(String key) {
        return (String) data.get(key);
    }

    /**
     * 获取int数据
     * @param key           属性名称
     * @return              整形值
     */
    public int getInt(String key) {
        return (Integer) data.get(key);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
