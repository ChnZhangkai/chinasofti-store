package com.chinasofti.app.controller;


import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.GoodsClassFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 主要查询商品分类的通用接口（一二级分类）
 * @author gezhenlin
 * @Date: 2017年11月15日 上午10:38:45
 */
@RestController
@RequestMapping("goodsClass")
public class GoodsClassController {
	
	@Autowired
	private GoodsClassFeignClient goodsFeignClient;
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsClassController.class);
	/**
	 * 当classId不为空时查询二级列表，为空时则查询一级分类
	 * @param classId(ids)
	 * @return
	 */
	@RequestMapping("queryClass")
	public ResponseInfo queryClass(@RequestParam(defaultValue ="000000") String classId){
		logger.info(classId);
		ResponseInfo response = new ResponseInfo();
		if(StringUtils.isEmpty(classId)){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("classId不能为空！");
			return response;
		}
		List<ChnGoodsClass> result = goodsFeignClient.queryClass(classId);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}

}
