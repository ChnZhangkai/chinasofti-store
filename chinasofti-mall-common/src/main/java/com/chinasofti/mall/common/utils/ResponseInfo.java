package com.chinasofti.mall.common.utils;

import java.util.Map;

public class ResponseInfo {

	private String retCode;
	
	private String retMsg;
	
	private Map<String, Object> data;
	
	public ResponseInfo(){
		this.retCode = "200";
		this.retMsg = "未知请求";
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
