package com.chinasofti.mall.goodsorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.common.service.IBaseService;

@RestController
@RequestMapping("order")
public class MainGoodsorderController extends BaseController<PyMainGoodsorder> {
	
	@Autowired
	IBaseService<PyMainGoodsorder> goodsorderService;

	@Override
	public IBaseService<PyMainGoodsorder> getService() {
		return goodsorderService;
	}

}
