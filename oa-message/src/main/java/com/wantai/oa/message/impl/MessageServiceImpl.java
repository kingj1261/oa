package com.wantai.oa.message.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wantai.oa.biz.shared.request.PageRequest;
import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.common.dal.mappings.dos.message.MessageDo;
import com.wantai.oa.common.dal.mappings.dos.message.RemindDo;
import com.wantai.oa.common.dal.mappings.dos.message.SuperviseDo;
import com.wantai.oa.message.MessageService;
import com.wantai.oa.message.request.MessageRequest;
import com.wantai.oa.message.request.RemindRequest;
import com.wantai.oa.message.request.SuperviseRequest;

/**
 * @author Sharpe on 2016-01-16.
 */
@Service
public class MessageServiceImpl extends BaseService implements MessageService {

	private final static String SQL_NAMESPACE = "Message.";

	@Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = { Exception.class })
	public void addSupervise(SuperviseDo superviseDo) {
		commonDAO.insert(SQL_NAMESPACE + "addMessage", superviseDo.getMessageDo());
        superviseDo.setMessageId(superviseDo.getMessageDo().getId());
		commonDAO.insert(SQL_NAMESPACE + "addSupervise", superviseDo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = { Exception.class })
	public void addRemind(RemindDo remindDo) {
		commonDAO.insert(SQL_NAMESPACE + "addMessage", remindDo.getMessageDo());
        remindDo.setMessageId(remindDo.getMessageDo().getId());
		commonDAO.insert(SQL_NAMESPACE + "addRemind", remindDo);
	}

	@Override
	@SuppressWarnings("all")
	public List<SuperviseDo> querySupervise(SuperviseRequest superviseRequest, PageRequest pageRequest) {
		return (List<SuperviseDo>) commonDAO.findByPagination(SQL_NAMESPACE + "querySupervise", superviseRequest,
				pageRequest.getPageNum(), pageRequest.getPageSize());
	}

	@Override
	@SuppressWarnings("all")
	public List<RemindDo> queryRemind(RemindRequest remindRequest, PageRequest pageRequest) {
		return (List<RemindDo>) commonDAO.findByPagination(SQL_NAMESPACE + "queryRemind", remindRequest,
				pageRequest.getPageNum(), pageRequest.getPageSize());
	}

	@Override
	@SuppressWarnings("all")
	public List<MessageDo> queryMessage(MessageRequest messageRequest, PageRequest pageRequest) {
		return (List<MessageDo>) commonDAO.findByPagination(SQL_NAMESPACE + "queryMessage", messageRequest,
				pageRequest.getPageNum(), pageRequest.getPageSize());
	}

    @Override
    public SuperviseDo findSuperviseById(Long superviseId) {
        return (SuperviseDo)commonDAO.selectOne(SQL_NAMESPACE+"findSuperviseById",superviseId);
    }

    @Override
    public RemindDo findRemindById(Long remindId) {
        return (RemindDo)commonDAO.selectOne(SQL_NAMESPACE+"findRemindById",remindId);
    }
}
