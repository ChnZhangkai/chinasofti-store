package com.chinasofti.mall.advertise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;


@RestController
@RequestMapping("advertise")
public class AdvertiseController extends BaseController<CmsAdContentsWithBLOBs>{
	
	@Autowired
	IBaseService<CmsAdContentsWithBLOBs> advertiseService;
	
	@Override
	public IBaseService<CmsAdContentsWithBLOBs> getService() {
		return advertiseService;
	}
	
}
