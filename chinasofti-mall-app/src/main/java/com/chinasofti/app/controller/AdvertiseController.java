package com.chinasofti.app.controller;



import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.AdvertiseFeignClient;
import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;

@RestController
@RequestMapping("advertise")
public class AdvertiseController {
	@Autowired
	AdvertiseFeignClient advertiseFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);



	@RequestMapping(value="findAdvertiseList")
	public ResponseInfo findAdvertiseList(@RequestParam("positionId") String positionId) {
		ResponseInfo response = new ResponseInfo();
		if (StringUtils.isEmpty(positionId)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("位置Id不能为空！");
			return response;
		}
		logger.info(positionId);
		 //处理广告列表返回的数据
		List<AdvertiseContents> result = advertiseFeignClient.findAdvertiseList(positionId);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}
	@RequestMapping(value="findAdvertise")
	public ResponseInfo findAdvertise(@RequestParam("positionId") String positionId) {
		ResponseInfo response = new ResponseInfo();
		if(StringUtils.isEmpty(positionId)){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("位置Id不能为空！");
			return response;
		}
		logger.info("查询位置ID"+positionId);
		AdvertiseContents result = advertiseFeignClient.findAdvertise(positionId);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}
   

}
