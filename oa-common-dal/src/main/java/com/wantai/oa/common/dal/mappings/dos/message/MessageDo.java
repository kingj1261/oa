package com.wantai.oa.common.dal.mappings.dos.message;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

/**
 * @author Sharpe on 2016-01-16.
 */
public class MessageDo extends BaseDo implements Serializable {

	/** 业务事项 **/
	@NotNull(message = "业务事项不能为空")
	private String bizItem;

	/** 业务事件 **/
	@NotNull(message = "业务事件不能为空")
	private String bizEvent;

	/** 截止日期 **/
	@NotNull(message = "截止日期不能为空")
	private Date endTime;

	/** 消息接收人编号 **/
	@NotNull(message = "消息接收人编号不能为空")
	private String customerId;

	/** 消息接收人名称 **/
	@NotNull(message = "消息接收人名称不能为空")
	private String customerName;

	/** 阅读状态 R-已读 NR-未读 **/
	@NotNull(message = "阅读状态不能为空")
	private String readStatus;

	/** 消息类型 **/
	@NotNull(message = "消息类型不能为空")
	private String messageType;

	/** 消息体内容 **/
	@NotNull(message = "消息体内容不能为空")
	private String messageBody;

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

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

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

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
}
