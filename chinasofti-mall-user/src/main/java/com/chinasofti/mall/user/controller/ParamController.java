package com.chinasofti.mall.user.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.common.entity.param.ParentParam;
import com.chinasofti.mall.user.service.ParamService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/param")
public class ParamController {
	
	@Autowired
	private ParamService paramServiceImpl;
	
	@RequestMapping("/findParamList")
	public JSONObject findParamList(@RequestBody(required = false) Integer pid){
		
		JSONObject js = new JSONObject();
		
		List<Param> list = paramServiceImpl.selectByPid(pid);
		
		if (pid != 0) {
			
			ParentParam parentParam = null;
			List<ParentParam> list2 = new ArrayList<ParentParam>();
			
			for (Param param : list) {
				parentParam = new ParentParam();
				parentParam.set_parentId(pid);
				try {
					BeanUtils.copyProperties(parentParam, param);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				int count = (paramServiceImpl.selectByPid(param.getId())).size();
				if(count > 0){
					parentParam.setState("closed");
				}
				list2.add(parentParam);
			}
			
			js.put("rows", list2);
			js.put("total", list2.size());
			return js;
			
		}else {
			for (Param param : list) {
				int count = (paramServiceImpl.selectByPid(param.getId())).size();
				if(count > 0){
					param.setState("closed");
				}
			}
		}
		js.put("rows", list);
		js.put("total", list.size());
		
		return js;
		
	}
	
}
