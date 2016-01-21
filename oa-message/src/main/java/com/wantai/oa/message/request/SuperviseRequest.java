package com.wantai.oa.message.request;

/**
 * 督办查询对象
 * @author Sharpe on 2016-01-16.
 */
public class SuperviseRequest extends MessageRequest {

    /** 被督办人 **/
    private String  customerName;

    /** 超期时间 **/
    private Integer outLimitDays;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getOutLimitDays() {
        return outLimitDays;
    }

    public void setOutLimitDays(Integer outLimitDays) {
        this.outLimitDays = outLimitDays;
    }
}
