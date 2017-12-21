package com.chinasofti.mall.web.entrance.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.web.entrance.feign.ParamFeigClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/param")
public class ParamController {
	
	@Autowired
	private ParamFeigClient paramFeigClient;
	
	@RequestMapping("/index")
	public ModelAndView toParamIndex() {
		return new ModelAndView("/param/param");
	}
	
	@RequestMapping("/list/{firstId}")
	public JSONObject findParamList(Param param,@PathVariable String firstId,String beforeId){
		if (!StringUtils.isEmpty(firstId)) {
			param.setId(Integer.parseInt(firstId));
			param.setStatus("1");
		}else {
			param.set_parentId(Integer.parseInt(beforeId));
		}
		return paramFeigClient.findAll(param);
	}
	
}
