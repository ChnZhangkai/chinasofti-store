package com.chinasofti.mall.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;
import com.chinasofti.mall.user.service.SpEvaluateService; 

import net.sf.json.JSONObject;

/**
 * @author: xiaozhiliang
 * @Date:   2017年121月19日:09时48分26秒
 *
 */
@RestController
@RequestMapping("/evaluate")
public class SpEvaluateController {
	
	@Autowired
	SpEvaluateService spEvaluateService;
	
	private static final Logger logger = LoggerFactory.getLogger(SpEvaluateController.class);
	
	@RequestMapping(value="/evaList")
	public JSONObject selectEvaluateList(@RequestBody SpGoodsEvaluate spGoodsEvaluate) {
		JSONObject js = null;
		try {
				logger.info("=======1========"+spGoodsEvaluate.toString());
				js = spEvaluateService.selectEvaluateList(spGoodsEvaluate);
				logger.info("=======2========"+js.toString());
			} catch (Exception e) {
				logger.info(e.getMessage());
				logger.info(e.toString());
		}
		return js;
	}
	
	@RequestMapping(value="/evaAllList")
	public JSONObject selectEvaluateAllList(@RequestBody SpGoodsEvaluate spGoodsEvaluate) {
		JSONObject js = null;
		try {	logger.info("=======11========"+spGoodsEvaluate.toString());
				js = spEvaluateService.selectEvaluateAllList(spGoodsEvaluate);
				logger.info("=======22========"+js.toString());
			} catch (Exception e) {
				logger.info(e.getMessage());
				logger.info(e.toString());
		}
		return js;
	}
	
	@RequestMapping(value="/evaAdd")
	public int insertSelective(@RequestBody SpGoodsEvaluate spGoodsEvaluate) {
		int result = 0;
		try {
				result = spEvaluateService.insertSelective(spGoodsEvaluate);
			} catch (Exception e) {
				logger.info(e.getMessage());
				logger.info(e.toString());
		}
		return result;
	}
}
