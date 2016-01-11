/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance
/**
 * 子表配置对象
 * @author maping.mp
 * @version $Id: SubConfigDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
class SubConfigDo extends ConfigDo {
    /** id */
    Long id;

    Long businessConfigId;

    /** 配置类型 */
    String subEventCode;

    /** 值*/
    String value;

    /** 开始值*/
    String fromValue;

    /** 结束值*/
    String toValue;

    /** 单位*/
    String unit;

    /** 是否启用 true-启用 false-不启用*/
    String memo;
}
