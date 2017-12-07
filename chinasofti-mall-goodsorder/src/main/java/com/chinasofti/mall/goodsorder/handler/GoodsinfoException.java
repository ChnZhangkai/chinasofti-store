package com.chinasofti.mall.goodsorder.handler;

public class GoodsinfoException extends Exception{

	private static final long serialVersionUID = 1L;
	private String value;  
	   
	GoodsinfoException()  
	{  
	super();  
	}  
	public GoodsinfoException(String msg,String value)  
	{  
	super(msg);  
	this.value = value;  
	}  
	   
	public String getValue()  
	{  
	return value;  
	}
}
