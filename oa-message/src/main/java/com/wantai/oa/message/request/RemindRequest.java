package com.wantai.oa.message.request;

/**
 * 提醒查询对象
 * @author Sharpe on 2016-01-16.
 */
public class RemindRequest extends MessageRequest {

    /** 提醒类型 **/
	private String remindType;


    public String getRemindType() {
        return remindType;
    }

    public void setRemindType(String remindType) {
        this.remindType = remindType;
    }
}
