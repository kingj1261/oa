/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.lang.enums;

/**
 * 配置类型定义
 *
 * @author maping.mp
 * @version $Id: ConfigTypeEnum.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public enum ConfigTypeEnum {

    /** 绩效系数 */
    GWXS("GWXS", "绩效系数"),

    /**岗位奖金*/
    GWJJ("GWJJ", "岗位奖金"),

    /** 岗位提成*/
    GWTC("GWTC", "岗位提成"),

    /** 基础设置*/
    JCSZ("JCSZ", "基础设置");

    /**返回码*/
    private String code;
    /**返回码对象的消息内容*/
    private String message;

    /**
     * 枚举私有构造函数
     * @param code
     * @param message
     */
    private ConfigTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过枚举值获取枚举对象
     * @param code 枚举值
     * @return  枚举对象
     */
    public static ConfigTypeEnum getByCode(String code) {
        for (ConfigTypeEnum result : values()) {
            if (result.getCode().equals(code)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
