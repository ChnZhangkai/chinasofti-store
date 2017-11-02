package com.chinasofti.mall.goodsorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.goodsorder.service.MainGoodsorderService;

/**
* @ClassName: 	MainGoodsorderController
* @Description: 主订单Controller
*
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 下午2:18:35 
*
*/
@RestController
@RequestMapping("mainorder")
public class MainGoodsorderController implements BaseController<PyMainGoodsorderWithBLOBs> {
	
	@Autowired
	private MainGoodsorderService mainGoodsorderService;
	
	@Override
	public List<PyMainGoodsorderWithBLOBs> findAll() {
		return null;
	}

	@Override
	@RequestMapping("select/{ids}")
	public PyMainGoodsorderWithBLOBs findById(@PathVariable("ids") String id) {
		
		return mainGoodsorderService.findById(id);
	}

	@Override
	@RequestMapping("delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) {
		mainGoodsorderService.deleteById(id);
		return "delete";
	}

	@Override
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {
		mainGoodsorderService.update(mainGoodsorderWithBLOBs);
		return "update";
	}

	@Override
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {
		mainGoodsorderService.save(mainGoodsorderWithBLOBs);
		return "add";
	}
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param mainGoodsorderWithBLOBs
	* @return List<PyMainGoodsorderWithBLOBs>
	* @throws
	*/
	@RequestMapping(value="list" , method = RequestMethod.POST)
	public List<PyMainGoodsorderWithBLOBs> selectByExample(@RequestBody(required=false) PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs){
		
		PyMainGoodsorderExample example = new PyMainGoodsorderExample();
		
		return mainGoodsorderService.selectByExample(example);
	}

}
