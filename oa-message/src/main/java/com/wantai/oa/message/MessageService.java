package com.wantai.oa.message;

import java.util.List;

import com.wantai.oa.biz.shared.request.PageRequest;
import com.wantai.oa.common.dal.mappings.dos.message.MessageDo;
import com.wantai.oa.common.dal.mappings.dos.message.RemindDo;
import com.wantai.oa.common.dal.mappings.dos.message.SuperviseDo;
import com.wantai.oa.message.request.MessageRequest;
import com.wantai.oa.message.request.RemindRequest;
import com.wantai.oa.message.request.SuperviseRequest;

/**
 * @author Sharpe on 2016-01-16.
 */
public interface MessageService {

	/** 增加督办信息 **/
	void addSupervise(SuperviseDo superviseDo);

	/** 增加提醒消息 **/
	void addRemind(RemindDo remindDo);

	/** 查询督办信息 **/
	List<SuperviseDo> querySupervise(SuperviseRequest superviseRequest, PageRequest pageRequest);

	/** 查询提醒消息 **/
	List<RemindDo> queryRemind(RemindRequest remindRequest, PageRequest pageRequest);

	/** 查询消息 **/
	List<MessageDo> queryMessage(MessageRequest messageRequest, PageRequest pageRequest);

	/** 查询督办信息详情 **/
	SuperviseDo findSuperviseById(Long superviseId);

	/** 查询提醒信息详情 **/
	RemindDo findRemindById(Long remindId);

}
