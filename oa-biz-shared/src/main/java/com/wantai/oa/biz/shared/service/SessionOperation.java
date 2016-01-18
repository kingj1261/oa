package com.wantai.oa.biz.shared.service;

import com.wantai.oa.biz.shared.vo.UserInfoVO;

public interface SessionOperation {
	UserInfoVO getOnLinuUser(String sid, final String source) throws Exception;
	boolean removeOnLineUser(final String sid, final String source) throws Exception;
}
