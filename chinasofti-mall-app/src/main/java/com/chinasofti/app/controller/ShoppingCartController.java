package com.chinasofti.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.GoodsInfoFeignClient;
import com.chinasofti.app.feign.ShoppingCartFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;
import com.chinasofti.mall.common.service.RequestParamService;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 购物车
 * @author heruilong/gezhenlin
 *
 */
@RestController
@RequestMapping("shoppingCart")
@Api(value = "ShoppingCartController", description = "购物车-API")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartFeignClient shoppingCartFeignClient;
	
	@Autowired
	private GoodsInfoFeignClient goodsInfoFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	/**
	 * 删除购物车商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="del/goods", method = RequestMethod.POST)
	//@ApiOperation(value="删除购物车商品", notes="报文示例：[{\"id\":\"1001\"},{\"id\":\"1002\"}]")
	public ResponseInfo deletePyShoppingCartById(@RequestBody List<PyShoppingCart> goodsList,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = new ResponseInfo();
		for (PyShoppingCart goods : goodsList) {
			// 空参校验
			responseInfo = RequestParamService.packageWithAddShoppingCartParam(goods);
			if (responseInfo.getRetCode() != null) {
				return responseInfo;
			}
		}
		responseInfo = shoppingCartFeignClient.deletePyShoppingCartById(goodsList);
		return responseInfo;
	}
	
	/**
	 * 加入购物车
	 * @param PyShoppingCart
	 * @return
	 */
	@RequestMapping(value="add/goods", method = RequestMethod.POST)
	//@ApiOperation(value="添加购物车商品", notes="报文示例：{\"goodsId\":\"1001\",\"userId\":\"chin\",\"goodsNum\":\"1\"}")
	public ResponseInfo savePyShoppingCart(@RequestBody PyShoppingCart shoppingCart,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		logger.info("请求参数《《《《《《《《《》》》》》》》》》》" + shoppingCart.toString());
		ResponseInfo responseInfo = new ResponseInfo();
		// 参数校验
		responseInfo = RequestParamService.packageWithAddShoppingCartParam(shoppingCart);
		if (responseInfo.getRetCode() != null) {
			return responseInfo;
		}
		logger.info("空参校验结果《《《《《《《《《》》》》》》》》》》" + responseInfo);
	/*	//调用本类中校验商品信息是否可行
		responseInfo = this.checkGoodsInfo(shoppingCart);
		if (!MsgEnum.SUCCESS.getCode().equals(responseInfo.getRetCode())) {
			return responseInfo;
		}*/
		logger.info("商品校验结果《《《《《《《《《》》》》》》》》》》" + response);
		responseInfo = shoppingCartFeignClient.savePyShoppingCart(shoppingCart);

		return responseInfo;
	}
	
	/**
	 * 更新购物车
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/mod/goods", method = RequestMethod.POST)
	//@ApiOperation(value="修改购物车商品数量", notes="报文示例：{\"goodsList\":{\"goodsList\":[{\"ids\":\"1\",\"goodsId\":\"1001\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"},{\"ids\":\"1\",\"goodsId\":\"1002\",\"userId\":\"chinasofti\",\"goodsNum\":\"3\"}]}")
	public ResponseInfo updatePyShoppingCart(@RequestBody PyShoppingCart goodsInfo,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = new ResponseInfo();
		//参数校验
		responseInfo = RequestParamService.packageWithShoppingCartRequestParam(goodsInfo);
		if(responseInfo.getRetCode() !=null){
			return responseInfo;
		}
		logger.info("空参校验结果+++++++++++===========" + response);
		int re = shoppingCartFeignClient.updatePyShoppingCart(goodsInfo);
		responseInfo = DealParamFunctions.dealResponseData(re);
		return responseInfo;
	}
	/**
	 * 查询购物车商品列表
	 * @param json
	 * @return
	 */
	@RequestMapping(value="query/goodsList")
	@ApiOperation(value="查询购物车商品", notes="报文示例：{\"userId\":\"1\"}")
	public ResponseInfo queryPyShoppingCartListByUserId(@RequestParam("userId") String userId){
		ResponseInfo response = new ResponseInfo();
		if (StringUtils.isEmpty(userId)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("userId不能为空！");
			return response;
		}
		List<VendorShoppingcartVO> res = shoppingCartFeignClient.queryPyShoppingCartListByUserId(userId);
		//封装前端需要的数据格式
		List<Map<String, List<ChnGoodsinfo>>> result = DealParamFunctions.pakacgeReponseData(res);
		response = DealParamFunctions.dealResponseData(result);
		return response;
	}

	/**
	 * 立即购买
	 * 之校验商品信息是否有效
	 * @param PyShoppingCart
	 * @return
	 */
	@RequestMapping(value ="checkGoodsInfo", method =RequestMethod.POST)
	public ResponseInfo checkGoodsInfo(@RequestBody PyShoppingCart shoppingCart) {
		ResponseInfo response = new ResponseInfo();
		String id = shoppingCart.getGoodsId();
		ChnGoodsinfo storegoodsInfo = goodsInfoFeignClient.checkGoodsInfoById(id);
		// 商品信息校验
		response = RequestParamService.packageWithGoodsInfoRequest(shoppingCart, storegoodsInfo);
		return response;

	}
}
