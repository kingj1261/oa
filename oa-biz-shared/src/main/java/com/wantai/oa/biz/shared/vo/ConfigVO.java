/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;


import java.io.Serializable;
import java.util.Set;

/**
 * 配置VO
 *
 * @author maping.mp
 * @version $Id: ConfigVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class ConfigVO implements Serializable {

    /** 配置key*/
    String configType;

    /** 业务事项集合*/
    Set<BizItemVO> bizItems;

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public Set<BizItemVO> getBizItems() {
        return bizItems;
    }

    public void setBizItems(Set<BizItemVO> bizItems) {
        this.bizItems = bizItems;
    }
}
