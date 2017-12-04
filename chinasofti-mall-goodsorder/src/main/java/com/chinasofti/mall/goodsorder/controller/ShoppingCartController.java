package com.chinasofti.mall.goodsorder.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goodsorder.service.PyShoppingCartService;
import com.github.pagehelper.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 购物车工程接口V1.0
 * @author 葛振淋/heruilong
 *
 */
@RestController
@RequestMapping("shoppingCart")
@Api(value = "ShoppingCartController", description = "购物车工程接口V1.0-API")
public class ShoppingCartController {
	
	@Autowired
	private PyShoppingCartService pyShoppingCartService;
	
	/**
	 * 删除购物车商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del/goods")
	@ApiOperation(value="删除购物车商品", notes="报文示例：[{\"id\":\"1001\"},{\"id\":\"1002\"}]")
	public ResponseInfo deletePyShoppingCartById(@RequestBody List<PyShoppingCart> goodsList) {
		return pyShoppingCartService.deletePyShoppingCartById(goodsList);
	}
	
	/**
	 * 加入购物车
	 * @param tt
	 * @return
	 */
	@RequestMapping(value="/add/goods")
	@ApiOperation(value="添加购物车商品", notes="报文示例：[{\"goodsId\":\"1001\",\"vendorId\":\"8888\",\"userId\":\"chin\",\"goodsNum\":\"1\"}]")
	public ResponseInfo savePyShoppingCart(@RequestBody List<PyShoppingCart> goodsList) {
		return pyShoppingCartService.savePyShoppingCart(goodsList);
	}

	/**
	 * 更新购物车
	 * @param t
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/mod/goods")
	@ApiOperation(value="修改购物车商品数量", notes="报文示例：[{\"ids\":\"1\",\"goodsId\":\"1001\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"},{\"ids\":\"1\",\"goodsId\":\"1002\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"}]")
	public ResponseInfo updatePyShoppingCart(@RequestBody PyShoppingCart goodsInfo) {
		ResponseInfo response = null;
		if (StringUtil.isEmpty(goodsInfo.getUserId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("userId不能为空！");
			return response;
		}
		if (StringUtil.isEmpty(goodsInfo.getId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("Id不能为空！");
			return response;
		}
		//封装一个参数校验的服务
		
		response = pyShoppingCartService.updatePyShoppingCart(goodsInfo);
		return response;
	}
	
	/**
	 * 查询购物车商品列表
	 * @param json
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/query/goodsList")
	@ApiOperation(value="查询购物车商品", notes="报文示例：{\"userId\":\"1\"}")
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestParam("userId") String userId) {
		
		ResponseInfo response = null;
		if (StringUtil.isEmpty(userId)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("userId不能为空！");
			return response;
		}

		response = pyShoppingCartService.queryPyShoppingCartListByUserId(userId);

		return response;
	}

}
