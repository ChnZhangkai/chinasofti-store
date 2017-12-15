package com.chinasofti.mall.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

	public static String getUuid(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", ""); 
		return uuid;
	}
	
	/**
	 * 生成9位随机字符串，数字+英文字母
	 * */
	public static String getRandomNum(){  
	      int  maxNum = 36;  
	      int i;  
	      int count = 0;  
	      char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',  
	        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
	        'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };      
	      StringBuffer pwd = new StringBuffer("");  
	      Random r = new Random();  
	      while(count < 9){  
	       i = Math.abs(r.nextInt(maxNum));     
	       if (i >= 0 && i < str.length) {  
	        pwd.append(str[i]);  
	        count ++;  
	       }  
	      }  
	      return pwd.toString();  
	    } 
		//时间戳
	    public static String nowTime(){
			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
			String nowTime = sd.format(date);
			return nowTime;
		}
	
}
