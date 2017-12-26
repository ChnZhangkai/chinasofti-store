package com.chinasofti.mall.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.goods.service.IPrefectureService;

@RestController
@RequestMapping("prefecture")
public class PrefectureController {

	@Autowired
	private IPrefectureService prefectureService;
	/**
	 * 查询所有专区
	 */
	@RequestMapping(value="/findAll", method = RequestMethod.POST)
	public List<GoodsPrefecture> findAll(){
		List<GoodsPrefecture> list = prefectureService.findAll();
		return list;
	}
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/select/{ids}" , method = RequestMethod.POST)
	public List<GoodsPrefecture> selectPrefectureById(@PathVariable String ids){
		List<GoodsPrefecture> list2 = prefectureService.findById(ids);
		 return list2;
	}
	/**
	 * 根据专区ids查询所属商品
	 */
	@RequestMapping(value="/findGoods",method= RequestMethod.POST)
	public List<ChnGoodsOnline> findGoodsById(@RequestBody(required = false) String ids){
		List<ChnGoodsOnline> findGoodsById = prefectureService.findGoodsById(ids);
		return findGoodsById;
	}
	/**
	 * 根据商品goodsids删除商品
	 */
	@RequestMapping(value="/deleteGoods/{goodsids}",method=RequestMethod.POST)
	public int deleteGoods(@PathVariable String goodsids){
		return prefectureService.deleteGoods(goodsids);
	}
 	/**
	 * 修改专区
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public int updatePrefecture(@RequestBody(required = false)GoodsPrefecture goodsPrefecture){
		return prefectureService.updateById(goodsPrefecture);
	}
	/**
	 * 增加专区
	 */
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public int savePrefecture(@RequestBody(required = false) GoodsPrefecture goodsPrefecture){
		return prefectureService.savePrefecture(goodsPrefecture);
	}
	/**
	 * 根据ids删除专区
	 */
	@RequestMapping(value="/delete/{ids}",method = RequestMethod.POST)
	public int deletePrefectureById(@PathVariable String ids){
		return prefectureService.deleteById(ids);
	}
	
}
