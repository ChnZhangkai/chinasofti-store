package com.chinasofti.mall.goodsorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;

@RestController
@RequestMapping("maingoodsorder")
public class MainGoodsorderController extends BaseController<PyMainGoodsorder> {
	
	@Autowired
	IBaseService<PyMainGoodsorder> goodsorderService;

	@Override
	public IBaseService<PyMainGoodsorder> getService() {
		return goodsorderService;
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updateByPrimaryKeySelective(@RequestBody(required = false) PyMainGoodsorderWithBLOBs goodsorderWithBLOBs) {
		
		return "add";
	}

}
