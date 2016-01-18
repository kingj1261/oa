package com.wantai.oa.biz.shared.helper;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	
	public static void addCookie(String sid,HttpServletResponse response){
	//写入cookie
	Cookie	cookie = new Cookie("sid",sid);
	cookie.setMaxAge(1800);
	cookie.setPath("/");  
	cookie.setDomain(SystemConfig.DOMAIN);
	response.addCookie(cookie);
	}
	
	
	
	public static void delCookie(HttpServletResponse response){
		Cookie	cookie = new Cookie("sid",null);
		cookie.setMaxAge(0);
		cookie.setPath("/");  
		cookie.setDomain(SystemConfig.DOMAIN);
		response.addCookie(cookie);
		}
	
	
	
}

