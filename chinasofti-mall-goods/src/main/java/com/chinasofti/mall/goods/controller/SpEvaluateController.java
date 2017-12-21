/**
 * 
 */
package com.chinasofti.mall.goods.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.goods.SpEvaluate;
import com.chinasofti.mall.goods.service.SpEvaluateService;


/**
 * @ClassName: GoodsCommentsController.java
 * @Description: 商品评论
 * @author zhoushanshan
 * @Date: 2017年12月20日 下午5:01:53
 * @parma <SpEvaluate>
 */
@RestController
@RequestMapping("/comments")
public class SpEvaluateController {
	
	@Autowired
	private SpEvaluateService GoodsCommentsServiceImpl;
	
	

	/**
	 * @Title: findByPage
	 * @Description: 分页查询
	 * @param map
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("findByPage")
	public Map<String, Object> findByCommentsPage(@RequestParam Map<String, Object> map) {
		 return GoodsCommentsServiceImpl.findByCommentsPage(map);
	
	}
	
	/**
	 * @Title: deleteById
	 * @Description: 分页查询
	 * @param map
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("delete/{ids}")
	public int deleteById(@PathVariable("ids") String id) {
		return GoodsCommentsServiceImpl.deleteById(id);
	}
	
	/**
	 * 查询评论图片
	 * @return
	 */
	@RequestMapping("/reqCommentsImgPath/{ids}")
	public SpEvaluate reqGoodsImgPath(@PathVariable String ids){
		return  GoodsCommentsServiceImpl.selectByCommentsIds(ids);	
		
		
		
	}

}
