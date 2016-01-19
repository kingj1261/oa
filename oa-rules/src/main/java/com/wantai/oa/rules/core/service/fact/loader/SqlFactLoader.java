/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.fact.loader;

import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.common.util.TemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * 事实数据加载器,通过sql方式执行
 * @author maping.mp
 * @version $Id: SqlFactLoader.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service("sqlFactLoader")
public class SqlFactLoader implements FactLoader {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List load(RuleDo ruleDo) {
        if (StringUtils.isEmpty(ruleDo.getDataExtractShell())) {
            return Collections.emptyList();
        }
        String renderedSql = rendSql(ruleDo.getDataExtractShell(), ruleDo);
        return jdbcTemplate.queryForList(renderedSql);
    }

    /**
     * 渲染sql
     * @param sql           sql语句
     * @param ruleDo        规则DO对象
     * @return
     */
    private String rendSql(String sql, RuleDo ruleDo) {
        return TemplateUtils.process(sql, ruleDo);
    }
}
