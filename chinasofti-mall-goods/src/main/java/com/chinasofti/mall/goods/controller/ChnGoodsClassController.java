package com.chinasofti.mall.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.goods.service.impl.ChnGoodsClassServiceImpl;
import com.github.pagehelper.util.StringUtil;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodsClass")
public class ChnGoodsClassController {
	
	@Autowired
	private ChnGoodsClassServiceImpl spGoodsClassService;
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public JSONObject selectByGoodsClass(@RequestBody(required = false)ChnGoodsClass chnGoodsClass){
		return spGoodsClassService.selectByExample(chnGoodsClass);
		
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/select/{ids}" , method = RequestMethod.POST)
	public ChnGoodsClass selectGoodsClassById(@PathVariable String ids){
		return spGoodsClassService.findById(ids);
		
	}
	
	/**
	 * 修改
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public int updateGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass){
		return spGoodsClassService.update(chnGoodsClass);
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete/{ids}" ,method = RequestMethod.POST)
	public int deleteGoodsClassById(@PathVariable String ids){
		return spGoodsClassService.deleteById(ids);
	}
	
	/**
	 * 添加
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public int saveGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass){
		return spGoodsClassService.save(chnGoodsClass);
	}
	/**
	 * 当Ids不为空时查询二级列表，为空时则查询一级分类
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/queryClass/{ids}" , method = RequestMethod.POST)
	public List<ChnGoodsClass> queryClass(@PathVariable String ids){
		List<ChnGoodsClass> goodsClass=null;
		if(StringUtil.isNotEmpty(ids)){
			goodsClass = spGoodsClassService.selectById(ids);
		}else{
			
			goodsClass = spGoodsClassService.selectByIsParent(Constant.IS_PARENT);
		}
		 
		return goodsClass;
		
	}
	
}
