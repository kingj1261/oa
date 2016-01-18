package com.wantai.oa.biz.shared.service.impl;

import com.wantai.oa.biz.shared.helper.SessionOperationTemplate;
import com.wantai.oa.biz.shared.service.SessionOperation;
import com.wantai.oa.biz.shared.vo.UserInfoVO;
import org.springframework.stereotype.Component;




@Component
public class SessionOperationImpl extends SessionOperationTemplate implements SessionOperation {

	@Override
	public UserInfoVO getOnLinuUser(String sid, String source)
			throws Exception {
		UserInfoVO onLineUserInfo = super.getOnLinuUser(sid, source);
		return onLineUserInfo;
	}

	@Override
	public boolean removeOnLineUser(String sid, String source)
			throws Exception {
		return super.removeOnLinuUser(sid, source);
	}
	
}
