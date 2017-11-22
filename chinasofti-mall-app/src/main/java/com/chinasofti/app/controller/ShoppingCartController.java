package com.chinasofti.app.controller;



import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.ShoppingCartFeignClient;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 购物车
 * @author heruilong
 *
 */
@RestController
@RequestMapping("shoppingCart")
//@Api(value = "ShoppingCartController", description = "购物车-API")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartFeignClient shoppingCartFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	/**
	 * 删除购物车商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="del/goods", method = RequestMethod.POST)
	//@ApiOperation(value="删除购物车商品", notes="报文示例：[{\"id\":\"1001\"},{\"id\":\"1002\"}]")
	public ResponseInfo deletePyShoppingCartById(@RequestBody List<PyShoppingCart> goodsList,HttpServletRequest req,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = shoppingCartFeignClient.deletePyShoppingCartById(goodsList);
		return responseInfo;
	}
	
	/**
	 * 加入购物车
	 * @param t
	 * @return
	 */
	@RequestMapping(value="add/goods", method = RequestMethod.POST)
	//@ApiOperation(value="添加购物车商品", notes="报文示例：[{\"goodsId\":\"1001\",\"userId\":\"chin\",\"goodsNum\":\"1\"},{\"goodsId\":\"1002\",\"userId\":\"chin\",\"goodsNum\":\"2\"}]")
	public ResponseInfo savePyShoppingCart(@RequestBody List<PyShoppingCart> goodsList,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("application/x-www-form-urlencoded","Content-Type");
		logger.info("请求参数《《《《《《《《《》》》》》》》》》》"+goodsList.toString());
		return shoppingCartFeignClient.savePyShoppingCart(goodsList);
	}

	/**
	 * 更新购物车
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/mod/goods", method = RequestMethod.POST)
	//@ApiOperation(value="修改购物车商品数量", notes="报文示例：{"goodsList":{\"goodsList\":[{\"ids\":\"1\",\"goodsId\":\"1001\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"},{\"ids\":\"1\",\"goodsId\":\"1002\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"}]}")
	public ResponseInfo updatePyShoppingCart(@RequestBody List<PyShoppingCart> goodsList,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = shoppingCartFeignClient.updatePyShoppingCart(goodsList);
		return responseInfo;
	}
	
	/**
	 * 查询购物车商品列表
	 * @param json
	 * @return
	 */
	@RequestMapping(value="query/goodsList")
	//@ApiOperation(value="查询购物车商品", notes="报文示例：{\"userId\":\"1\"}")
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestParam("userId") String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		ResponseInfo responseInfo = shoppingCartFeignClient.queryPyShoppingCartListByUserId(userId);
		return responseInfo;
	}
	/**
	 * 统一获取请求参数
	 * @param req
	 * @return
	 */
	public static String getRequestPayload(HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = req.getReader();
			char[] buff = new char[1024];
			int len;
			while ((len = reader.read(buff)) != -1) {
				sb.append(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();

	  }

}
