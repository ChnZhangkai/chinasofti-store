package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.web.entrance.feign.MainGoodsorderFeign;

/**
* @ClassName: 	MainGoodsorderController
* @Description: 主订单消费端controller
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 下午5:41:08 
*/
@RestController
@RequestMapping("mainorder")
public class MainGoodsorderController {
	
	@Autowired
	private MainGoodsorderFeign mainGoodsorderFeign;
	
	
	/**
	* @Title: getView
	* @Description: 跳转订单页面
	* @return ModelAndView
	* @throws
	*/
	@RequestMapping("/index")
	public ModelAndView getView() {
		return  new ModelAndView("/order/goodsorder");
	}
	
	/**
	* @Title: selectByPrimaryKey
	* @Description: 通过主键查询
	* @param ids
	* @return PyMainGoodsorderWithBLOBs
	* @throws
	*/
	@RequestMapping("select/{ids}")
	public PyMainGoodsorder selectByPrimaryKey(@PathVariable String ids){
		
		return mainGoodsorderFeign.findById(ids);
		
	}
	
	/**
	* @Title: selectAll
	* @Description: 条件查询
	* @param mainGoodsorderWithBLOBs
	* @return List<PyMainGoodsorderWithBLOBs>
	* @throws
	*/
	@RequestMapping(value="list", method = RequestMethod.POST)
	public List<PyMainGoodsorder> selectAll(PyMainGoodsorder mainGoodsorder){
		
		return mainGoodsorderFeign.selectByExample(mainGoodsorder);
	}
	
	
	/**
	* @Title: orderAdd
	* @Description: 添加主订单
	* @param mainGoodsorderWithBLOBs
	* @return  String
	* @throws
	*/
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String orderAdd(PyMainGoodsorder mainGoodsorder) {
		mainGoodsorderFeign.add(mainGoodsorder);
		return "add";
	}

	/**
	* @Title: orderDeleteById
	* @Description: 通过主键删除
	* @param ids
	* @return String
	* @throws
	*/
	@RequestMapping(value = "delete/{ids}")
	public String orderDeleteById(@PathVariable String ids) {

		return mainGoodsorderFeign.deleteById(ids);

	}
	
	
	/**
	* @Title: orderUpdate
	* @Description: 更改
	* @param mainGoodsorderWithBLOBs
	* @return String
	* @throws
	*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String orderUpdate(PyMainGoodsorder mainGoodsorder) {

		return mainGoodsorderFeign.update(mainGoodsorder);

	}

}
