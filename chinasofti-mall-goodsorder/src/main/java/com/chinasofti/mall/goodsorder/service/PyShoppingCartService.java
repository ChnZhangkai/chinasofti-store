package com.chinasofti.mall.goodsorder.service;

import java.util.List;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface PyShoppingCartService  {

	public ResponseInfo queryPyShoppingCartListByUserId(String userId);
	
	public ResponseInfo savePyShoppingCart(List<PyShoppingCart>goodsList);

	public ResponseInfo updatePyShoppingCart(PyShoppingCart goodsList);
	
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList);
	
}
