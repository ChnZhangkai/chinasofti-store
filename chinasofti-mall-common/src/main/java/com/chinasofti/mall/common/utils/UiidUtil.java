package com.chinasofti.mall.common.utils;

import java.util.UUID;

public class UiidUtil {

	public static String getUiid(){
		String uiid = UUID.randomUUID().toString().replaceAll("-", ""); 
		return uiid;
	}
}
