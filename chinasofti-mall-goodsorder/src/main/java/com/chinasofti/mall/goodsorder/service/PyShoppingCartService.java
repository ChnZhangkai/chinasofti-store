package com.chinasofti.mall.goodsorder.service;

import java.util.List;

 
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface PyShoppingCartService  {

	public List<VendorShoppingcartVO> queryPyShoppingCartListByUserId(String userId);
	
	public ResponseInfo savePyShoppingCart(PyShoppingCart goodsInfo);

	public int updatePyShoppingCart(PyShoppingCart goodsInfo);
	
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList);
	
}
