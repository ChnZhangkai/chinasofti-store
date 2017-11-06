package com.chinasofti.mall.goodsorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.PyChildGoodsorderExample;
import com.chinasofti.mall.goodsorder.service.ChildGoodsorderService;


/**
* @ClassName: 	ChildGoodsorderController
* @Description: 子订单controller
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 下午2:16:51 
*/
@RestController
@RequestMapping("childorder")
public class ChildGoodsorderController implements BaseController<PyChildGoodsorder> {
	
	@Autowired
	private ChildGoodsorderService childGoodsorderService;
	
	@Override
	public List<PyChildGoodsorder> findAll() {
		return null;
	}

	@Override
	@RequestMapping("select/{ids}")
	public PyChildGoodsorder findById(@PathVariable("ids") String id) {
		
		return childGoodsorderService.findById(id);
	}

	@Override
	@RequestMapping("delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) {
		childGoodsorderService.deleteById(id);
		return "delete";
	}

	@Override
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PyChildGoodsorder childGoodsorder) {
		childGoodsorderService.update(childGoodsorder);
		return "update";
	}

	@Override
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PyChildGoodsorder childGoodsorder) {
		childGoodsorderService.save(childGoodsorder);
		return "add";
	}
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param childGoodsorder
	* @return List<PyChildGoodsorder>
	* @throws
	*/
	@RequestMapping(value="list" , method = RequestMethod.POST)
	public List<PyChildGoodsorder> selectByExample(@RequestBody(required=false) PyChildGoodsorder childGoodsorder){
		
		PyChildGoodsorderExample example = new PyChildGoodsorderExample();
		
		return childGoodsorderService.selectByExample(example);
	}

}
