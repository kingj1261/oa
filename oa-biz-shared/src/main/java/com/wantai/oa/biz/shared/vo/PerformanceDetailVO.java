package com.wantai.oa.biz.shared.vo;

/**
 * Desc: PerformanceDetailVO
 * Date: 2016-01-22
 * Time: 上午 11:15
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
public class PerformanceDetailVO {
    String customerId;
    String queryTime;
    String configType;

    String beganTime;
    String endTime;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getBeganTime() {
        return beganTime;
    }

    public void setBeganTime(String beganTime) {
        this.beganTime = beganTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
