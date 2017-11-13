package com.chinasofti.mall.common.utils;

public enum MsgEnum {

	SUCCESS("000000", "交易成功"),
	ERROR("900001", "交易失败"),
	SERVER_ERROR("999999", "服务器异常");
	
	private String code;
	
	private String msg;
	
	MsgEnum(String code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
