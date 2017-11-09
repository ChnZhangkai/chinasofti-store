package com.chinasofti.mall.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.goods.service.impl.ChnGoodsCheckServiceImpl;

import net.sf.json.JSONObject;

/**
 * 商品审核
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goodsCheck")
public class ChnGoodsCheckController {
	
	@Autowired
	private ChnGoodsCheckServiceImpl chnGoodsCheckService;
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public JSONObject selectByGoodsCheck(@RequestBody(required = false)ChnGoodsinfoCheck chnGoodsinfoCheck){
		return chnGoodsCheckService.selectByExample(chnGoodsinfoCheck);
		
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/select/{ids}" , method = RequestMethod.POST)
	public ChnGoodsinfoCheck selectGoodsCheckById(@PathVariable String ids){
		return chnGoodsCheckService.findById(ids);
		
	}
	
	/**
	 * 修改
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public int updateGoodsCheck(@RequestBody(required = false) ChnGoodsinfoCheck chnGoodsinfoCheck){
		return chnGoodsCheckService.update(chnGoodsinfoCheck);
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete/{ids}" ,method = RequestMethod.POST)
	public int deleteGoodsCheckById(@PathVariable String ids){
		return chnGoodsCheckService.deleteById(ids);
	}
	
	/**
	 * 添加
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public int saveGoodsCheck(@RequestBody(required = false) ChnGoodsinfoCheck chnGoodsinfoCheck){
		return chnGoodsCheckService.save(chnGoodsinfoCheck);
	}
	
}
