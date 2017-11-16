package com.chinasofti.mall.common.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String getUuid(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", ""); 
		return uuid;
	}
}
