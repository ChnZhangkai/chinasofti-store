package com.chinasofti.mall.advertise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.chinasofti.mall.advertise.service.IAdvertiseService;
import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;

/**
 * 
* @ClassName: AdvertiseController
* @Description: 广告服务controller
* @author kanmeng
* @date 2017年11月1日 下午10:44:48 
* @version
 */
@RestController
@RequestMapping("advertise")
public class AdvertiseController implements BaseController<CmsAdContentsWithBLOBs>{
	
	@Autowired
	IAdvertiseService advertiseService;

	@Override
	@RequestMapping("findAll")
	public List<CmsAdContentsWithBLOBs> findAll() {
		return advertiseService.findAll();
	}
	
	@Override
	@RequestMapping("findById/{id}")
	public CmsAdContentsWithBLOBs findById(@PathVariable String id) {
		return advertiseService.findById(id);
	}
	
	@Override
	@RequestMapping("deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		advertiseService.deleteById(id);
		return "";
	}

	@Override
	@RequestMapping("update")
	public String update(CmsAdContentsWithBLOBs t) {
		 advertiseService.update(t);
		return "";
	}

	@Override
	@RequestMapping("add")
	public String add(CmsAdContentsWithBLOBs t) {
		advertiseService.save(t);
		return "";
	}
	
	@RequestMapping("findByPage")
	public String findByPage(@RequestParam Map<String,Object> map) {
		//Map<String,Object> map = new HashMap<>();
		//map.put("pageSize",pageSize );
		//map.put("pageNumber", pageNumber);
		return advertiseService.findByPage(map);
	}
	
	
}
