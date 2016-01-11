/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.rule

import com.wantai.oa.common.dal.mappings.dos.BaseDo

/**
 * 规则do对象
 * @author maping.mp
 * @version $Id: RuleDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
class RuleDo extends BaseDo {

    /** 配置类型 */
    String configType;

    /** 业务事项*/
    String bizItem;

    /** 业务事件*/
    String bizEvent;

    /** 规则内容*/
    String rules;

    /** 数据抽取器*/
    String dataExtractor;

    /** 数据抽取脚本*/
    String dataExtractShell;
}
