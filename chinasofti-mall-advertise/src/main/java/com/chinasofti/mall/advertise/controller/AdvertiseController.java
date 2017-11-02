package com.chinasofti.mall.advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;

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
	IBaseService<CmsAdContentsWithBLOBs> advertiseService;

	@Override
	public List<CmsAdContentsWithBLOBs> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsAdContentsWithBLOBs findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CmsAdContentsWithBLOBs t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(CmsAdContentsWithBLOBs t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
