package com.chinasofti.mall.advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public int deleteById(@PathVariable String id) {
		return advertiseService.deleteById(id);
	}

	@Override
	@RequestMapping("update")
	public int update(CmsAdContentsWithBLOBs t) {
		return advertiseService.update(t);
	}

	@Override
	@RequestMapping("add")
	public int add(CmsAdContentsWithBLOBs t) {
		return advertiseService.save(t);
	}
	
	
	
}
