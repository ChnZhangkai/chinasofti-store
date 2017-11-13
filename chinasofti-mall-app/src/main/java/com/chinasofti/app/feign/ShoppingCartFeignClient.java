package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 访问购物车工程
 * @author heruilong
 *
 */
@FeignClient("goodsorder-service")
public interface ShoppingCartFeignClient {

	@ResponseBody
	@RequestMapping(value="/shoppingCart/V1.0//query/goodsList", method = RequestMethod.POST)
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestBody JSONObject json);
	
	@ResponseBody
	@RequestMapping(value="/shoppingCart/V1.0/add/goods", method = RequestMethod.POST)
	public ResponseInfo savePyShoppingCart(@RequestBody JSONObject json);

	@ResponseBody
	@RequestMapping(value="/shoppingCart/V1.0/mod/goods", method = RequestMethod.POST)
	public ResponseInfo updatePyShoppingCart(@RequestBody JSONObject json);
	
	@ResponseBody
	@RequestMapping(value="/shoppingCart/V1.0/del/goods", method = RequestMethod.POST)
	public ResponseInfo deletePyShoppingCartById(@RequestBody JSONObject json);
}
