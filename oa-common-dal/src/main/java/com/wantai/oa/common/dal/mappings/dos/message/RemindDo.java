package com.wantai.oa.common.dal.mappings.dos.message;

import javax.validation.constraints.NotNull;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

/**
 * @author Sharpe on 2016-01-16.
 */
public class RemindDo extends BaseDo {

    /** 消息主体 **/
    @NotNull(message = "消息体不能为空")
    private MessageDo messageDo;

	/** 消息id **/
	@NotNull(message = "消息id不能为空")
	private Long messageId;

	/** 提醒类型 **/
	@NotNull(message = "提醒类型不能为空")
	private String remindType;

    public MessageDo getMessageDo() {
        return messageDo;
    }

    public void setMessageDo(MessageDo messageDo) {
        this.messageDo = messageDo;
    }

    public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getRemindType() {
		return remindType;
	}

	public void setRemindType(String remindType) {
		this.remindType = remindType;
	}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RemindDo{");
        sb.append("messageDo=").append(messageDo);
        sb.append(", messageId=").append(messageId);
        sb.append(", remindType='").append(remindType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
