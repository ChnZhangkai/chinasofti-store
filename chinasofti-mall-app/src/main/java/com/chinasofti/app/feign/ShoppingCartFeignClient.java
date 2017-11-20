package com.chinasofti.app.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.app.hystrix.ShoppingCartFeignClientHystrix;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 访问购物车工程
 * @author heruilong
 *
 */
@FeignClient(name="goodsorder-service",fallback = ShoppingCartFeignClientHystrix.class)
public interface ShoppingCartFeignClient {

	@RequestMapping(value="/shoppingCart/query/goodsList")
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestParam("userId") String userId);
	
	@ResponseBody
	@RequestMapping(value="/shoppingCart/add/goods")
	public ResponseInfo savePyShoppingCart(@RequestBody Map<String,Object> requestMap);

	@ResponseBody
	@RequestMapping(value="/shoppingCart/mod/goods")
	public ResponseInfo updatePyShoppingCart(@RequestBody List<PyShoppingCart> goodsList);
	
	@ResponseBody
	@RequestMapping(value="/shoppingCart/del/goods")
	public ResponseInfo deletePyShoppingCartById(@RequestBody List<PyShoppingCart> goodsList);
}
