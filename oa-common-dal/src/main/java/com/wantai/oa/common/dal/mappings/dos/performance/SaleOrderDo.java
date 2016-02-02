/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.performance;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

/**
 * 车辆销售记录对象
 *
 * @author maping.mp
 * @version $Id: SaleOrderDo.java, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class SaleOrderDo extends BaseDo {

    Integer customerId;

    Integer departId;

    String  role;

    String  configType;

    String  bizItem;

    String  bizEvent;

    int     saleCounts;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getBizItem() {
        return bizItem;
    }

    public void setBizItem(String bizItem) {
        this.bizItem = bizItem;
    }

    public String getBizEvent() {
        return bizEvent;
    }

    public void setBizEvent(String bizEvent) {
        this.bizEvent = bizEvent;
    }

    public int getSaleCounts() {
        return saleCounts;
    }

    public void setSaleCounts(int saleCounts) {
        this.saleCounts = saleCounts;
    }
}
