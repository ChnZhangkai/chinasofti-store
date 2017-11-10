package com.chinasofti.mall.goodsorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.order.PyPayorder;
import com.chinasofti.mall.common.entity.order.PyPayorderExample;
import com.chinasofti.mall.goodsorder.service.PayorderService;


/**
* @ClassName: 	PayorderController
* @Description: 支付订单controller
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 下午2:21:10 
*/
@RestController
@RequestMapping("payorder")
public class PayorderController implements BaseController<PyPayorder> {
	
	@Autowired
	private PayorderService payorderService;
	
	@Override
	public List<PyPayorder> findAll() {
		return null;
	}

	@Override
	@RequestMapping("select/{ids}")
	public PyPayorder findById(@PathVariable("ids") String id) {
		
		return payorderService.findById(id);
	}

	@Override
	@RequestMapping("delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) {
		payorderService.deleteById(id);
		return "delete";
	}

	@Override
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PyPayorder payorder) {
		payorderService.update(payorder);
		return "update";
	}

	@Override
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PyPayorder payorder) {
		payorderService.save(payorder);
		return "add";
	}
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param payorder
	* @return List<PyPayorder>
	* @throws
	*/
	@RequestMapping(value="list" , method = RequestMethod.POST)
	public List<PyPayorder> selectByExample(@RequestBody(required=false) PyPayorder payorder){
		
		PyPayorderExample example = new PyPayorderExample();
		
		return payorderService.selectByExample(example);
	}

}
