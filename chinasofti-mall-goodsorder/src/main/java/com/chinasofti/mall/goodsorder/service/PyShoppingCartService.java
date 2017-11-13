package com.chinasofti.mall.goodsorder.service;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface PyShoppingCartService  extends IBaseService<PyShoppingCart> {

	public ResponseInfo queryPyShoppingCartListByUserId(String userId);
	
	public ResponseInfo savePyShoppingCart(JSONObject json);

	public ResponseInfo updatePyShoppingCart(JSONObject json);
	
	public ResponseInfo deletePyShoppingCartById(String id);
	
}
