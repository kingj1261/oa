/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance

import com.wantai.oa.common.dal.mappings.dos.BaseDo

/**
 * 绩效do对象
 * @author maping.mp
 * @version $Id: ConfigDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
class ConfigDo extends BaseDo {

    /** 配置类型 */
    String configType;

    /** 业务事项*/
    String bizItem;

    /** 业务事件*/
    String bizEvent;

    /** 业务事项名称*/
    String bizItemName;

    /** 业务事件名称*/
    String bizEventName;

    /** 业务事项顺序*/
    int bizItemOrder;

    /** 业务事件顺序*/
    int bizEventOrder;

    /** 值*/
    String value;

    /** 单位*/
    String unit;

    /** 是否启用 true-启用 false-不启用*/
    String enable;

    /** 目标对象*/
    String target;

    /** 开始日期*/
    Date startTime=new Date();

    /** 结束日期*/
    Date endTime=new Date();
}
