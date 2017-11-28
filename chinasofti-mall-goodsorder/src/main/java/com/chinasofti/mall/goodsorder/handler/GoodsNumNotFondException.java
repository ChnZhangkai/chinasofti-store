package com.chinasofti.mall.goodsorder.handler;

public class GoodsNumNotFondException extends Exception{

	private static final long serialVersionUID = 1L;
	private String value;  
	   
	GoodsNumNotFondException()  
	{  
	super();  
	}  
	public GoodsNumNotFondException(String msg,String value)  
	{  
	super(msg);  
	this.value = value;  
	}  
	   
	public String getValue()  
	{  
	return value;  
	}
}
