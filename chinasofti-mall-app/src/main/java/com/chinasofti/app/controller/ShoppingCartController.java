package com.chinasofti.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.app.feign.ShoppingCartFeignClient;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 购物车
 * @author heruilong
 *
 */
@RestController
@RequestMapping("/shoppingCart")
@Api(value = "ShoppingCartController", description = "购物车-API")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartFeignClient shoppingCartFeignClient;
	
	/**
	 * 删除购物车商品
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/del/goods", method = RequestMethod.POST)
	@ApiOperation(value="删除购物车商品", notes="报文示例：{'id':'1001'}")
	public ResponseInfo deletePyShoppingCartById(@RequestBody JSONObject json) {
		ResponseInfo responseInfo = shoppingCartFeignClient.deletePyShoppingCartById(json);
		return responseInfo;
	}
	
	/**
	 * 加入购物车
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add/goods", method = RequestMethod.POST)
	@ApiOperation(value="添加购物车商品", notes="报文示例：{'goodsId':'1001','userId':'chinasofti','goodsNum':'1'}")
	public ResponseInfo savePyShoppingCart(@RequestBody JSONObject json) {
		ResponseInfo responseInfo = shoppingCartFeignClient.savePyShoppingCart(json);
		return responseInfo;
	}

	/**
	 * 更新购物车
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/mod/goods", method = RequestMethod.POST)
	@ApiOperation(value="修改购物车商品数量", notes="报文示例：{'ids':'1','goodsId':'1001','userId':'chinasofti','goodsNum':'3'}")
	public ResponseInfo updatePyShoppingCart(@RequestBody JSONObject json) {
		ResponseInfo responseInfo = shoppingCartFeignClient.updatePyShoppingCart(json);
		return responseInfo;
	}
	
	/**
	 * 查询购物车商品列表
	 * @param json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/query/goodsList", method = RequestMethod.POST)
	@ApiOperation(value="查询购物车商品", notes="报文示例：{'userId':'1'}")
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestBody JSONObject json){
		ResponseInfo responseInfo = shoppingCartFeignClient.queryPyShoppingCartListByUserId(json);
		return responseInfo;
	}


}
