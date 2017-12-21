package com.chinasofti.mall.user.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.common.entity.param.ParentParam;
import com.chinasofti.mall.user.service.ParamService;
import com.github.pagehelper.Page;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/param")
public class ParamController {
	
	@Autowired
	private ParamService paramServiceImpl;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/list")
	public JSONObject findAll(@RequestBody(required = false)Param param){
		JSONObject js = new JSONObject();
		ParentParam pp = new ParentParam();
		List list = paramServiceImpl.findAll(param);
		try {
			BeanUtils.copyProperties(pp, list.get(0));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		list.remove(0);
		list.add(pp);
		js.put("rows", list);
		js.put("total", ((Page<Param>)list).getTotal());
		
		return js;
	}
	
}
