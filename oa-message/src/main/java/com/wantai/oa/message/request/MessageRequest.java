package com.wantai.oa.message.request;

import java.util.Date;

/**
 * 消息列表查询对象
 * @author Sharpe on 2016-01-16.
 */
public class MessageRequest {

	/** 阅读状态 **/
	private String readStatus;

	/** 消息类别 **/
	private String messageType;

	/** 开始时间 **/
	private Date beginDate;

	/** 结束时间 **/
	private Date endDate;

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MessageRequest{");
		sb.append("readStatus='").append(readStatus).append('\'');
		sb.append(", messageType='").append(messageType).append('\'');
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append('}');
		return sb.toString();
	}
}
