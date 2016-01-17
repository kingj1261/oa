package com.wantai.oa.web.interceptor;

import com.wantai.oa.auth.service.UserLoginService;
import com.wantai.oa.biz.shared.vo.UserInfoVO;
import com.wantai.oa.biz.shared.helper.ContextHolderUtils;
import com.wantai.oa.biz.shared.helper.CookieUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Aspect
public class AuthInterceptor implements HandlerInterceptor{
	
	@Autowired
	private UserLoginService userLoginService;
	
//	preHandle---对请求进行预处理
	/**
	 * preHandle---对请求进行预处理
	 * 对请求进行拦截，先判断在本地session里面是否有userInfo,有放走
	 * 没有userInfo，就调用加载userInfo的方法，查看在redis服务器中是否有该请求的userInfo;
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handle) throws Exception {
		UserInfoVO userInfo = ContextHolderUtils.getCurrentUserInfo();
		if(userInfo == null){
			if(loadUserInfo(request,response)){
				return true;
			}
			System.out.println("请求被拦截");
			return false;
		}else {
			return true;
		}
	}
	
	public boolean loadUserInfo(HttpServletRequest request,HttpServletResponse response){
		String sid = request.getParameter("sid");
		System.out.println(sid);
		if(sid != null && !sid.equals("")){
			try {
				UserInfoVO userToRedis = userLoginService.getUserToRedis(sid);
				if(userToRedis != null){
					ContextHolderUtils.setCurrentUserInfo(userToRedis);
					CookieUtils.addCookie(sid, response);
					return true;
				}else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	

	
//	afterCompletion---对请求进行拦截后处理
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	// postHandle---返回处理
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	
}
