package com.wantai.oa.common.lang.enums;

/**
 * @author Sharpe on 2016-01-16.
 */
public enum MessageTypeEnum {

	/** 系统消息 **/
	SYSTEM("SYSTEM", "系统消息"),

	/** 业务消息 **/
	BUSINESS("BUSINESS", "业务消息"),

	/** oa消息 **/
	OA("OA", "oa消息"),

	/** 电商消息 **/
	ESHOP("ESHOP", "电商消息");

	/**返回码*/
	private String code;
	/**返回码对象的消息内容*/
	private String message;

	/**
	 * 枚举私有构造函数
	 * @param code 编码
	 * @param message 描述
	 */
	MessageTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 通过枚举值获取枚举对象
	 * @param code 枚举值
	 * @return  枚举对象
	 */
	public static MessageTypeEnum getByCode(String code) {
		for (MessageTypeEnum result : values()) {
			if (result.getCode().equals(code)) {
				return result;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
