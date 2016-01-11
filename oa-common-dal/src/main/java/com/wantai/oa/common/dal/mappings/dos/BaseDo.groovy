/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos

import groovy.transform.ToString

/**
 * 基础DO对象
 * @author maping.mp
 * @version $Id: BaseDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
@ToString
class BaseDo implements Serializable {
    /** 逻辑主键id */
    Long id;

    /** 公司码 */
    String companyCode;

    /** 公司id */
    Long companyId;

    /** 备注 */
    String memo;

    /** 操作员 */
    String operator;

    /** 最后一次修改操作员 */
    String lastModifiedOperator;

    /** 创建日期 */
    Date gmtCreate;

    /** 最后一次修改日期 */
    Date gmtModified;
}
