package com.chinasofti.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.AdvertiseFeignClient;
import com.chinasofti.mall.common.entity.AdvertiseContents;

@RestController
@RequestMapping("advertise")
public class AppController {
	@Autowired
	AdvertiseFeignClient advertiseFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);



	@RequestMapping("findAdvertiseList")
	public List<AdvertiseContents> findAdvertiseList(@RequestParam AdvertiseContents advertiseContents) {
		logger.info(advertiseContents.toString());
		return advertiseFeignClient.findAdvertiseList(advertiseContents);
	}
	@RequestMapping("findAdvertise")
	public AdvertiseContents findAdvertise(@RequestParam String positionId) {
		logger.info("查询位置ID"+positionId);
		return advertiseFeignClient.findAdvertise(positionId);
	}

}
