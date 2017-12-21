package com.chinasofti.app.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.ShoppingCartFeignClientHystrix;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 访问购物车工程
 * @author heruilong
 *
 */
@FeignClient(name="goodsorder-service",url="http//localhost:7601",fallback = ShoppingCartFeignClientHystrix.class)
public interface ShoppingCartFeignClient {

	@RequestMapping(value="/shoppingCart/query/goodsList")
	public List<VendorShoppingcartVO> queryPyShoppingCartListByUserId(@RequestParam("userId") String userId);
	
	@RequestMapping(value="/shoppingCart/add/goods", method = RequestMethod.POST)
	public ResponseInfo savePyShoppingCart(@RequestBody PyShoppingCart goodsInfo);

	@RequestMapping(value="/shoppingCart/mod/goods", method = RequestMethod.POST)
	public int updatePyShoppingCart(@RequestBody PyShoppingCart goodsInfo);
	
	@RequestMapping(value="/shoppingCart/del/goods", method = RequestMethod.POST)
	public ResponseInfo deletePyShoppingCartById(@RequestBody List<PyShoppingCart> goodsList);
}
