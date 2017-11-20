package com.chinasofti.app.controller;


import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.AdvertiseFeignClient;
import com.chinasofti.mall.common.utils.ResponseInfo;

@RestController
@RequestMapping("advertise")
public class AdvertiseController {
	@Autowired
	AdvertiseFeignClient advertiseFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);



	@RequestMapping(value="findAdvertiseList")
	public ResponseInfo findAdvertiseList(@RequestParam String positionId,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info(positionId);
		return advertiseFeignClient.findAdvertiseList(positionId);
	}
	@RequestMapping(value="findAdvertise")
	public ResponseInfo findAdvertise(@RequestParam String positionId,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("查询位置ID"+positionId);
		return advertiseFeignClient.findAdvertise(positionId);
	}
   

}
