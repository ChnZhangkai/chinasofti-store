package com.chinasofti.mall.goods.service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;

public interface ChnGoodsCheckService extends IBaseService<ChnGoodsinfoCheck> {

	JSONObject selectByExample(ChnGoodsinfoCheck chnGoodsinfoCheck);

	int deleteById(String ids);

}
