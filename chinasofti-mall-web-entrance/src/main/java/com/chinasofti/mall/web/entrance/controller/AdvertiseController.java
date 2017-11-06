package com.chinasofti.mall.web.entrance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.AdvertiseContents;
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
	public List<AdvertiseContents> findAll() {
		return advertiseFeignClient.findAll();	
	}
	
	@RequestMapping("findByPage")
	public String findByPage(@RequestParam Map<String,Object> map) {
		return advertiseFeignClient.findByPage(map);	
	}
	
}
