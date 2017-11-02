package com.chinasofti.mall.goodsorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.goodsorder.service.MainGoodsorderService;

@RestController
@RequestMapping("/mainorder")
public class MainGoodsorderController implements BaseController<PyMainGoodsorderWithBLOBs>{
	
	@Autowired
	private MainGoodsorderService mainGoodsorderService;
	
	@RequestMapping(value="/list" , method = RequestMethod.POST)
	public List<PyMainGoodsorderWithBLOBs> selectByExample(@RequestBody(required = false) PyMainGoodsorderWithBLOBs pyMainGoodsorderWithBLOBs){
		
		PyMainGoodsorderExample example = new PyMainGoodsorderExample();
		
		return mainGoodsorderService.selectByExample(example);
	}

	@Override
	public List<PyMainGoodsorderWithBLOBs> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PyMainGoodsorderWithBLOBs findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(PyMainGoodsorderWithBLOBs t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(PyMainGoodsorderWithBLOBs t) {
		// TODO Auto-generated method stub
		return null;
	}

}
