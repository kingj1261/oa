/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.lang.result

import groovy.transform.ToString

/**
 * 公共返回数据对象
 * @author maping.mp
 * @version $Id: CommonResult.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@ToString
class CommonResult implements Serializable{

    /** 处理结果*/
    boolean success=true

    /** 结果码*/
    String  resultCode

    /** 结果描述*/
    String  resultCodeDesc
}
