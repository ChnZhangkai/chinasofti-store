package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.web.entrance.feign.MainGoodsorderFeign;


@RestController
@RequestMapping("mainorder")
public class MainGoodsorderController {
	
	@Autowired
	private MainGoodsorderFeign mainGoodsorderFeign;
	
	/**
	 * 返回订单列表页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView getView() {
		return  new ModelAndView("/mainorder/goodsorder");
	}
	
	/**
	 * id查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("select/{ids}")
	public PyMainGoodsorderWithBLOBs selectByPrimaryKey(@PathVariable String ids){
		
		return mainGoodsorderFeign.findById(ids);
		
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping(value="list", method = RequestMethod.POST)
	public List<PyMainGoodsorderWithBLOBs> selectAll(PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs){
		
		return mainGoodsorderFeign.selectByExample(mainGoodsorderWithBLOBs);
	}
	
	
	/**
	 * 商品添加
	 * 
	 * @param pyMainGoodsorder
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String goodsAdd(PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {
		mainGoodsorderFeign.add(mainGoodsorderWithBLOBs);
		return "add";
	}

	/**
	 * 通过ID删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "delete/{ids}")
	public String goodsDeleteById(@PathVariable String ids) {

		return mainGoodsorderFeign.deleteById(ids);

	}
	
	
	/**
	 * 修改
	 * @param pyMainGoodsorder
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String goodsUpdate(PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {

		return mainGoodsorderFeign.update(mainGoodsorderWithBLOBs);

	}

}
