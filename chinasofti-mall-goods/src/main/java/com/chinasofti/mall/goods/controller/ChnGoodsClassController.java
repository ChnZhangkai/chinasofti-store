package com.chinasofti.mall.goods.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;

import com.chinasofti.mall.goods.service.IChnGoodsClassService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("goodsClass")
public class ChnGoodsClassController {
	
	@Autowired
	private IChnGoodsClassService GoodsClassService;
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public JSONObject selectByGoodsClass(@RequestBody(required = false)ChnGoodsClass chnGoodsClass){
		return GoodsClassService.selectByExample(chnGoodsClass);
	}
	
	/**
	 * 分类查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/findGoodsClass", method = RequestMethod.POST)
	public List<ChnGoodsClass> findGoodsClass(@RequestBody(required = false) String ids){
		List<ChnGoodsClass> jsonlist = GoodsClassService.findGoodsClass(ids);
		return jsonlist;
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/select/{ids}" , method = RequestMethod.POST)
	public ChnGoodsClass selectGoodsClassById(@PathVariable String ids){
		return GoodsClassService.findById(ids);
		
	}
	
	/**
	 * 修改
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public int updateGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass){
		return GoodsClassService.updateById(chnGoodsClass);
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete/{ids}" ,method = RequestMethod.POST)
	public int deleteGoodsClassById(@PathVariable String ids){
		return GoodsClassService.deleteById(ids);
	}
	
	/**
	 * 添加
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public int saveGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass){
		return GoodsClassService.saveGoodsClass(chnGoodsClass);
	}
	/**
	 * 通过classId查询商品分类（分一级与二级分类）
	 * @param classId
	 * @return
	 */
	@RequestMapping(value = "queryClass")
	public List<ChnGoodsClass> queryClass(@RequestParam("classId") String classId){
		
		return GoodsClassService.queryClass(classId);
		
	}
	
}
