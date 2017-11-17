package com.chinasofti.mall.user.handler;

public class MyException extends Exception {
	private String code;
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MyException(String code,String message) {
        super(message);
        this.code=code;
    }

}
