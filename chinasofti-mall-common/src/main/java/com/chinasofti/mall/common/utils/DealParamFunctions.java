package com.chinasofti.mall.common.utils;

import java.util.HashMap;
import java.util.Map;


public class DealParamFunctions {

	//封装返回参数
			public final static  ResponseInfo dealResponseData(Object result) {
				ResponseInfo  response= new ResponseInfo();
				if(result !=null){
					Map<String, Object> data= new HashMap<String, Object>();
					data.put("responseInfo", result);
					response.setData(data);
					response.setRetCode(MsgEnum.SUCCESS.getCode());
					response.setRetMsg(MsgEnum.SUCCESS.getMsg());
				}else if("".equals(result)){
					response.setRetCode(MsgEnum.ERROR.getCode());
					response.setRetMsg(MsgEnum.ERROR.getMsg());
				}else{
					response.setRetCode(MsgEnum.ERROR.getCode());
					response.setRetMsg("未找到相关数据！");	
				}
				return response;
			}
}
