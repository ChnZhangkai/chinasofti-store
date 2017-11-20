package com.chinasofti.mall.goodsorder.service;

import java.util.List;


import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface PyShoppingCartService  extends IBaseService<PyShoppingCart> {

	public ResponseInfo queryPyShoppingCartListByUserId(String userId);
	
	public ResponseInfo savePyShoppingCart(List<PyShoppingCart>goodsList);

	public ResponseInfo updatePyShoppingCart(List<PyShoppingCart>goodsList);
	
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList);
	
}
