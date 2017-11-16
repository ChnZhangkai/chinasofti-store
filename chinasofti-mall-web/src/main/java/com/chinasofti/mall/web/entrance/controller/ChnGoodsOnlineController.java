package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
 
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodsOnline")
public class ChnGoodsOnlineController {
	
	@Autowired
	ChnGoodsFeignClient chnGoodsFeignClient;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodsonline");
	}
	
	
	/**
	 * 列表及条件查询
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsOnline(ChnGoodsOnline chnGoodsOnline){
		JSONObject jsonlist = chnGoodsFeignClient.selectByGoodsOnline(chnGoodsOnline);
		return jsonlist.toString();
	}
	
	
	/**
	 * 商品状态修改
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping("/updateGoodsStatus")
	public int updateGoodsStatus(ChnGoodsOnline chnGoodsOnline){
		return chnGoodsFeignClient.updateGoodsStatus(chnGoodsOnline);
		
	}
	
	/**
	 * 商品库存修改
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping("/update")
	public int updateStore(ChnGoodsOnline chnGoodsOnline){
		return chnGoodsFeignClient.updateStore(chnGoodsOnline);
		
	}
}
