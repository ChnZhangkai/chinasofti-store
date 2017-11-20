package com.chinasofti.mall.goodsorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goodsorder.service.PyShoppingCartService;

/**
 * 购物车工程接口V1.0
 * @author heruilong
 *
 */
@RestController
@RequestMapping("/shoppingCart/")
@Api(value = "ShoppingCartController", description = "购物车工程接口V1.0-API")
public class ShoppingCartController {
	
	@Autowired
	private PyShoppingCartService pyShoppingCartService;
	
	/**
	 * 删除购物车商品
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/del/goods", method = RequestMethod.POST)
	@ApiOperation(value="删除购物车商品", notes="报文示例：{\"goodsList\":[{\"id\":\"1001\"},{\"id\":\"1002\"}]}")
	public ResponseInfo deletePyShoppingCartById(@RequestBody List<PyShoppingCart> goodsList) {
		return pyShoppingCartService.deletePyShoppingCartById(goodsList);
	}
	
	/**
	 * 加入购物车
	 * @param tt
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add/goods", method = RequestMethod.POST)
	@ApiOperation(value="添加购物车商品", notes="报文示例：{\"goodsList\":[{\"goodsId\":\"1001\",\"userId\":\"chin\",\"goodsNum\":\"1\"},{\"goodsId\":\"1002\",\"userId\":\"chin\",\"goodsNum\":\"2\"}]}")
	public ResponseInfo savePyShoppingCart(@RequestBody List<PyShoppingCart> goodsList) {
		return pyShoppingCartService.savePyShoppingCart(goodsList);
	}

	/**
	 * 更新购物车
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/mod/goods", method = RequestMethod.POST)
	@ApiOperation(value="修改购物车商品数量", notes="报文示例：{\"goodsList\":[{\"ids\":\"1\",\"goodsId\":\"1001\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"},{\"ids\":\"1\",\"goodsId\":\"1002\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"}]}")
	public ResponseInfo updatePyShoppingCart(@RequestBody List<PyShoppingCart> goodsList) {
		return pyShoppingCartService.updatePyShoppingCart(goodsList);
	}
	
	/**
	 * 查询购物车商品列表
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/query/goodsList", method = RequestMethod.POST)
	@ApiOperation(value="查询购物车商品", notes="报文示例：{\"userId\":\"1\"}")
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestParam("userId") String userId){
		return pyShoppingCartService.queryPyShoppingCartListByUserId(userId);
	}

}
