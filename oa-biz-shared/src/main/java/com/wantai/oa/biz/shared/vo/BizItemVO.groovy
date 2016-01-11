/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo

import groovy.transform.EqualsAndHashCode


/**
 * 业务事项VO
 *
 * @author maping.mp
 * @version $Id: BizItemVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */

@EqualsAndHashCode(includes = ["bizItem"])
class BizItemVO implements Serializable {

    /** 业务事项编号*/
    String bizItem;

    /** 业务事项名称*/
    String bizItemName;

    /** 排序*/
    int order;

    /** 业务事件集合*/
    List<BizEventVO> bizEvents=new ArrayList<>();
}
