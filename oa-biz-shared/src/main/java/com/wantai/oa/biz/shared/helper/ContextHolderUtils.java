package com.wantai.oa.biz.shared.helper;

import com.wantai.oa.biz.shared.vo.UserInfoVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ContextHolderUtils {
	
	
	
	private static String LOGINUSER="LOGINUSER";
	
	/**
	 * SpringMvc下获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}
	/**
	 * SpringMvc下获取session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;
	}
	
	
	public static UserInfoVO getCurrentUserInfo() {
		HttpSession session = getRequest().getSession();
		UserInfoVO attribute = (UserInfoVO) session.getAttribute(LOGINUSER);
		return attribute;
	}
	
	
	public static void setCurrentUserInfo(UserInfoVO userinfo) {
		HttpSession session = getRequest().getSession();
		session.setAttribute(LOGINUSER, userinfo);
	}
	
	public static void delCurrentUserInfo() {
		HttpSession session = getRequest().getSession();
		session.removeAttribute(LOGINUSER);
	}
}
