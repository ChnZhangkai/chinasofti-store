package com.cn.test;

import java.math.BigDecimal;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.goodsorder.service.PyShoppingCartService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCarTest {

	@Autowired
	private PyShoppingCartService shoppingCartService;
	
	@Test
	public void addShoppingCar(){
		PyShoppingCart goods= new PyShoppingCart();
		goods.setId("650cdf8142684ef5b0d713bdaa48aebd");
		goods.setGoodsId("1003");
		goods.setUserId("chin2");
		goods.setVendorId("8888");
		goods.setGoodsNum(new BigDecimal("2"));
		shoppingCartService.savePyShoppingCart(goods);
	}
}
