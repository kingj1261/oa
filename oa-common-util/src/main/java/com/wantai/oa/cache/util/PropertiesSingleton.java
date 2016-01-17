package com.wantai.oa.cache.util;

public class PropertiesSingleton {  
    private static PropertiesUtil instance;  
    private PropertiesSingleton (){}  
    public static synchronized PropertiesUtil getInstance() {  
    if (instance == null) {  
        instance  = new PropertiesUtil("sysConfig.properties");
    }  
    return instance;  
    }  
} 
