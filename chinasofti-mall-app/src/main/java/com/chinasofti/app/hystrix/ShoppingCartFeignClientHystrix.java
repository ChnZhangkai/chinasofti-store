package com.chinasofti.app.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.ShoppingCartFeignClient;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;
import com.chinasofti.mall.common.utils.ResponseInfo;

@Component
public class ShoppingCartFeignClientHystrix implements ShoppingCartFeignClient{

	@Override
	public List<VendorShoppingcartVO> queryPyShoppingCartListByUserId(String userId) {
		
		return new ArrayList<VendorShoppingcartVO>();
	}

	@Override
	public ResponseInfo savePyShoppingCart(PyShoppingCart goods) {
		return new ResponseInfo();
	}

	@Override
	public int updatePyShoppingCart(PyShoppingCart goodsInfo) {
		return new Integer("999999");
	}

	@Override
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList) {
		return new ResponseInfo();
	}



}
