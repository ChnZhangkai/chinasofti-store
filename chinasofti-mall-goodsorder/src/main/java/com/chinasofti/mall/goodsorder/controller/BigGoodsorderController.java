/*package com.chinasofti.mall.goodsorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorderExample;
import com.chinasofti.mall.goodsorder.service.BigGoodsorderService;


*//**
* @ClassName: 	BigGoodsorderController
* @Description: 大订单controller
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:30:17 
*//*
@RestController
@RequestMapping("/bigorder")
public class BigGoodsorderController implements BaseController<PyBigGoodsorder> {
	
	@Autowired
	private BigGoodsorderService bigGoodsorderService;
	
	@Override
	@RequestMapping("/all")
	public List<PyBigGoodsorder> findAll() {
		
		return bigGoodsorderService.findAll();
	}

	@Override
	@RequestMapping("select/{ids}")
	public PyBigGoodsorder findById(@PathVariable("ids") String id) {
		
		return bigGoodsorderService.findById(id);
	}

	@Override
	@RequestMapping("delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) {
		bigGoodsorderService.deleteById(id);
		return "delete";
	}

	@Override
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PyBigGoodsorder bigGoodsorder) {
		bigGoodsorderService.update(bigGoodsorder);
		return "update";
	}

	@Override
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PyBigGoodsorder bigGoodsorder) {
		bigGoodsorderService.save(bigGoodsorder);
		return "add";
	}
	
	*//**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param bigGoodsorder
	* @return List<PyBigGoodsorder>
	* @throws
	*//*
	@RequestMapping(value="list" , method = RequestMethod.POST)
	public List<PyBigGoodsorder> selectByExample(@RequestBody(required=false) PyBigGoodsorder bigGoodsorder){
		
		PyBigGoodsorderExample example = new PyBigGoodsorderExample();
		
		return bigGoodsorderService.selectByExample(example);
	}

}
*/