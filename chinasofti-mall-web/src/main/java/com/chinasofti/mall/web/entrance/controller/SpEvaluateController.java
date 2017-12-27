/**
 * 
 */
package com.chinasofti.mall.web.entrance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.goods.SpEvaluate;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;

/**
 * @ClassName: GoodsCommentsController.java
 * @Description: 商品评论服务消费
 * @author zhoushanshan
 * @Date: 2017年12月20日 下午4:31:18
 * @parma <SpEvaluate>
 */
@RestController
@RequestMapping("/comments")
public class SpEvaluateController {
	@Autowired
	ChnGoodsFeignClient chnGoodsFeignClient;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodsComment");
	}
		
	/**
	 * 分页查询
	 * @param　pageSize
	 * @return
	 */
	@RequestMapping("/findByPage")
	public String findByCommentPage(@RequestParam Map<String, Object> map) {
		System.out.println("findByPage:"+map.toString());
		return chnGoodsFeignClient.findByCommentPage(map);
	}
	
	/**
	 * 通过主键删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delete/{ids}")
	public int commentsDeleteById(@PathVariable String ids) {
		return chnGoodsFeignClient.deleteById(ids);
	}
	
	
	/**
	 * 通过批量删除评论
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "batchDeletes/{temID}")
	public int batchDeletes(@PathVariable String temID){
        List<String> delList = new ArrayList<String>();
        String[] strs = temID.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        System.out.println("数据:"+delList);
       return chnGoodsFeignClient.batchDeletes(delList);	 
	}
	
	/**
	 * 商品评论页面查询评论图片
	 * @return
	 */
	@RequestMapping("/reqCommentsImgPath/{ids}")
	public String reqGoodsImgPath(@PathVariable String ids){
		SpEvaluate spevaluate = chnGoodsFeignClient.selectByCommentsIds(ids);	
		String str = spevaluate.getImagepath();
		return str;
	}
}
