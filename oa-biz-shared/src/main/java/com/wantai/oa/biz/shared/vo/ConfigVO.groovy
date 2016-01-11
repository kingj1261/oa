/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo


/**
 * 配置VO
 *
 * @author maping.mp
 * @version $Id: ConfigVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
class ConfigVO implements Serializable {

    /** 配置key*/
    String configType;

    /** 业务事项集合*/
    Set<BizItemVO> bizItems;
}
