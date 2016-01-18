package com.wantai.oa.message.request;

import java.util.Date;

import com.wantai.oa.common.dal.mappings.dos.message.MessageDo;

/**
 * 消息列表查询对象
 * @author Sharpe on 2016-01-16.
 */
public class MessageRequest extends MessageDo {

	/** 开始时间 **/
	private Date beginDate;

	/** 结束时间 **/
	private Date endDate;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
