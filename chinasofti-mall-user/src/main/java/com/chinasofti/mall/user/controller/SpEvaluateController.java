package com.chinasofti.mall.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;
import com.chinasofti.mall.user.service.SpEvaluateServince;

import net.sf.json.JSONObject;

/**
 * @author: xiaozhiliang
 * @Date:   2017年121月19日:09时48分26秒
 *
 */
@RestController
@RequestMapping("/evaluate")
public class SpEvaluateController {
	private static final Logger logger = LoggerFactory.getLogger(SpUserController.class);
	
	SpEvaluateServince spEvaluateServince;
	@RequestMapping(value="/evaList")
	public JSONObject selectEvaluateList(@RequestBody SpGoodsEvaluate spGoodsEvaluate) {
		JSONObject js = new JSONObject();
		try {
				js = spEvaluateServince.selectEvaluateList(spGoodsEvaluate);

			} catch (Exception e) {
				logger.info(e.getMessage());
				logger.info(e.toString());
		}
		return js;
	}
	
	@RequestMapping(value="/evaAllList")
	public JSONObject selectEvaluateAllList(@RequestBody SpGoodsEvaluate spGoodsEvaluate) {
		JSONObject js = new JSONObject();
		try {
				js = spEvaluateServince.selectEvaluateAllList(spGoodsEvaluate);

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
				result = spEvaluateServince.insertSelective(spGoodsEvaluate);

			} catch (Exception e) {
				logger.info(e.getMessage());
				logger.info(e.toString());
		}
		return result;
	}
}
