/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.request;

import com.wantai.oa.biz.shared.vo.BizBonusVO;
import com.wantai.oa.common.lang.enums.ConfigTypeEnum;
import com.wantai.oa.common.lang.enums.CustomerTypeEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 岗位奖金/提成请求对象
 *
 * @author maping.mp
 * @version $Id: BonusRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BonusRequest implements Serializable {

    /** 客户类型-默认为公司*/
    private String           customerType = CustomerTypeEnum.CUSTOMER.getCode();

    /** 用户编号*/
    private String           customerId;

    /** 配置类型,默认为岗位奖金*/
    private String           configType   = ConfigTypeEnum.GWJJ.getCode();

    /** 事项事件配置对象*/
    private List<BizBonusVO> bizItems     = new ArrayList<>();

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public List<BizBonusVO> getBizItems() {
        return bizItems;
    }

    public void setBizItems(List<BizBonusVO> bizItems) {
        this.bizItems = bizItems;
    }
}
