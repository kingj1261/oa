package com.wantai.oa.common.dal.mappings.dos.message;

import javax.validation.constraints.NotNull;

import com.wantai.oa.common.dal.mappings.dos.BaseDo;

/**
 * @author Sharpe on 2016-01-16.
 */
public class SuperviseDo  extends BaseDo{

    /** 消息主体 **/
    @NotNull(message = "消息体不能为空")
    private MessageDo messageDo;

	/** 消息id **/
	@NotNull(message = "消息id不能为空")
	private Long messageId;

	/** 超期日期 **/
	@NotNull(message = "超期日期不能为空")
	private Integer outLimitDays;

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

	public Integer getOutLimitDays() {
		return outLimitDays;
	}

	public void setOutLimitDays(Integer outLimitDays) {
		this.outLimitDays = outLimitDays;
	}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SuperviseDo{");
        sb.append("messageDo=").append(messageDo);
        sb.append(", messageId=").append(messageId);
        sb.append(", outLimitDays=").append(outLimitDays);
        sb.append('}');
        return sb.toString();
    }
}
