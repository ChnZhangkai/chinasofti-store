package com.cn.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.goodsorder.service.impl.PyShoppingCartServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest

public class ShoppingCarTest {

	@Autowired
	private PyShoppingCartServiceImpl shoppingCartService;
	
	@Test
	public void addShoppingCar(){
		List<PyShoppingCart>goodsList = new ArrayList<PyShoppingCart>();
		PyShoppingCart goods= new PyShoppingCart();
		goods.setIds("650cdf8142684ef5b0d713bdaa48aebd");
		goods.setGoodsIds("1003");
		goods.setUserId("chin2");
		goods.setVendorid("8888");
		goods.setGoodsNum(new BigDecimal("2"));
		goodsList.add(goods);
		shoppingCartService.savePyShoppingCart(goodsList);
	}
}
