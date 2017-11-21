package com.chinasofti.mall.common.utils;

import java.util.Map;

public class ResponseInfo {
	  public static final String ERROR = "100";

	private String retCode;
	
	private String retMsg;
	
	private String url;
	
	private Map<String, Object> data;
	
	public ResponseInfo(){
		this.retCode = "200";
		this.retMsg = "未知请求";
	}

	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
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
