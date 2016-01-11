/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.request

import com.wantai.oa.common.lang.enums.ConfigTypeEnum;

/**
 * 公共请求基类
 * @author maping.mp
 * @version $Id: BaseRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
class BaseRequest implements Serializable {
    /** 公司码 */
    String companyCode;

    /** 公司id */
    Long companyId;

    /** 配置类型*/
    ConfigTypeEnum configType;

    /** 业务事项*/
    String bizItem;

    /** 业务事件*/
    String bizEvent;

    /** 值*/
    String value;

    /** 单位*/
    String unit;

    /** 备注 */
    String memo;

    /** 操作员 */
    String operator;

    /** 最后一次修改操作员 */
    String lastModifiedOperator;
}
