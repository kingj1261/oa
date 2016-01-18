package com.wantai.oa.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hanjuntao
 * @datetime 2015-07-16 17:24
 */
public class BaseUtils {

    public static Log logger = LogFactory.getLog(BaseUtils.class);

    /**
     * 判断对象是否Empty(null或元素为0)<br>
     * 对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param obj 待检查对象
     * @return boolean 返回的布尔值
     */

    public static final String CURRENCY = "IDR";

    public static final int COUNTRY_ID = 62;

    public static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public final static int DEFAULT_PAGE_SIZE = 10;

    public final static int DEFAULT_PAGE = 1;
    
 	// 验证码模板
 	private static final String[] SOURCE = { "1", "2", "3", "4", "5", "6", "7",
 	                                        "8", "9" };

    public static boolean isEmpty(Object obj) {
        if (obj == null){
        	 return true;
        }
        if (obj == ""){
        	return true;
        }
        if (obj instanceof String) {
            if (((String) obj).length() == 0) {
                return true;
            }
        }else if(obj instanceof Long){
        	if (((Long) obj).longValue() == 0l) {
                return true;
            }
        }else if(obj instanceof Integer){
        	if (((Integer) obj).intValue() == 0) {
                return true;
            }
        }else if(obj instanceof Float){
        	if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
        }else if(obj instanceof Double){
        	if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
        }else if(obj instanceof Short){
        	if (((Short) obj).shortValue() == 0) {
                return true;
            }
        }else if (obj instanceof Collection) {
            if (((Collection<?>) obj).size() == 0 || ((Collection<?>) obj).isEmpty()) {
                return true;
            }
        } else if (obj instanceof Map ) {
            if (((Map<?,?>) obj).size() == 0 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断对象是否为NotEmpty(!null或元素>0)<br>
     * 对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param obj 待检查对象
     * @return boolean 返回的布尔值
     */
    public static boolean isNotEmpty(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj == "") {
			return false;
		}
		if(obj instanceof String) {
			if(((String) obj).length() == 0 || ((String)obj).trim().equals("")) {
				return false;
			}
		} else if(obj instanceof Long) {
			if(((Long) obj).longValue() == 0l) {
				return false;
			}
		} else if(obj instanceof Integer) {
			if(((Integer) obj).intValue() == 0) {
				return false;
			}
		} else if(obj instanceof Float) {
			if(((Float) obj).floatValue() == 0.0f) {
				return false;
			}
		} else if(obj instanceof Double) {
			if(((Double) obj).doubleValue() == 0.0d) {
				return false;
			}
		} else if(obj instanceof Short) {
			if(((Short) obj).shortValue() == 0) {
				return false;
			}
		} else if(obj instanceof Collection) {
			if(((Collection<?>) obj).size() == 0 || ((Collection<?>) obj).isEmpty()) {
				return false;
			}
		} else if(obj instanceof Map) {
			if(((Map<?,?>) obj).size() == 0 || ((Map<?,?>) obj).isEmpty()) {
				return false;
			}
		}
		return true;
    }

    public static <T> T parseObject(String jsonString, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(DEFAULT_DATE_FORMAT);
        T result = null;
        try {
            result = mapper.readValue(jsonString,valueType);
        } catch (IOException e) {
            logger.error("JSON转换对象出错!",e);
        }
        return result;
    }

    public static <T> T parseObject(String jsonString, TypeReference<T> typeReference){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(DEFAULT_DATE_FORMAT);
        T result = null;
        try {
            result = mapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            logger.error("JSON转换对象出错!",e);
        }
        return result;
    }

    /**
     * Java对象之间属性值拷贝(Dto、Map、JavaBean)
     *
     * @param fromObj
     *            Bean源对象
     * @param toObj
     *            Bean目标对象
     */
    public static void copyProperties(Object fromObj, Object toObj) {
        if (toObj != null) {
            try {
                BeanUtils.copyProperties(toObj, fromObj);
            } catch (Exception e) {
                logger.error("拷贝java bean 属性出错!", e);
            }
        }
    }
    
    public static String toJSON(Object obj) {
    	return JSON.toJSONString(obj);
    }

    public static void main(String[] args) {
        //Dto dto = new LinkedHashDto();
        //dto.put("date",new Date());
    	Long begin = System.currentTimeMillis();
    	Long end = System.currentTimeMillis();
    }

    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("encode error.",e);
            return null;
        }
    }
    
    /**
     * 
    * @Description: 生成32为uuid 
    * @return 设定文件 
    * @author 肖红斌
    * @date 2015年9月29日 下午12:30:27
     */
    public static String getUUID(){    
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");    
        return uuid;    
    }  
    
    /**
     * @Description: 生成六位数的短信验证码
     * @return 设定文件 
     * @throws 
     * @author LJH
     */
    public static String getSmsCode() {
		StringBuilder authCode = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			int index = (int) Math.round(Math.random() * 8);
			authCode.append(SOURCE[index]);
		}
		return authCode.toString();
	}
    
    public static String transHumpToUnderline(String hump){
    	if(BaseUtils.isEmpty(hump)){
    		return "";
    	}
    	List<Integer> record = new ArrayList<Integer>();  
        for (int i = 0; i < hump.length(); i++) {  
            char tmp = hump.charAt(i);  
            if ((tmp <= 'Z') && (tmp >= 'A')) {  
                record.add(i);// 记录每个大写字母的位置  
            }  
        }  
        if (null == record || record.size() == 0) {  
            return hump;  
        }  
        hump = hump.toLowerCase();  
        char[] charofstr = hump.toCharArray();  
        String[] t = new String[record.size()];  
        for (int i = 0; i < record.size(); i++) {  
            t[i] = "_" + charofstr[(Integer) record.get(i)];  
        }  
        StringBuilder result = new StringBuilder("");  
        int flag = 0;  
        for (int i = 0; i < hump.length(); i++) {  
            if ((flag < record.size()) && (i == (Integer) record.get(flag))) {  
                result.append(t[flag]);  
                flag++;  
            } else  
                result.append(charofstr[i]);  
        }  
        return result.toString();  
    }
    
}
