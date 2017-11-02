package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.web.entrance.feign.AdvertiseFeignClient;

@RestController
@RequestMapping("advertise")
public class AdvertiseController {
	
	@Autowired
	AdvertiseFeignClient advertiseFeignClient;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/advertise/advertise");
	}
	
	@RequestMapping("findAll")
	public List<CmsAdContentsWithBLOBs> findAll() {
		return advertiseFeignClient.findAll();	
	}
}
