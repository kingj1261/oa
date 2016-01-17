package com.wantai.oa.biz.shared.helper;

import com.wantai.oa.cache.util.PropertiesSingleton;
import com.wantai.oa.cache.util.PropertiesUtil;

public class SystemConfig {
public	static PropertiesUtil instance;
	static{
		
		instance = PropertiesSingleton.getInstance();
	}
	
	public	static String DOMAIN=instance.readProperty("domain");
	
	public	static String ADMINNAME=instance.readProperty("adminName");
	
	
	public	static String ERPLOGIN=instance.readProperty("erpLogin");
	
}
