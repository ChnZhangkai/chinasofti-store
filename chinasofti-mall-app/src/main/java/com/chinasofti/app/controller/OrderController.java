package com.chinasofti.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.app.feign.OrderFeignClient;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 商城 app 订单相关的操作
 * @ClassName: OrderController.java
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月24日 上午10:38:45
 * @parma <T>
 */
@RestController
@RequestMapping("/order")
@Api(value = "OrderController", description = "订单-API")
public class OrderController {

	@Autowired
	private OrderFeignClient orderFeignClient;

	/**
	 * 删除订单
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del/order", method = RequestMethod.POST)
	@ApiOperation(value = "删除订单", notes = "报文示例：{'orderId':'1001'}")
	public ResponseInfo deleteOrderById(String orderId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.deleteOrderById(orderId);
		return responseInfo;
	}

	/**
	 * 提交订单
	 * 保存子订单信息，生成大订单，主订单
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/add/order", method = RequestMethod.POST)
	@ApiOperation(value = "提交商品信息，保存订单", notes = "报文示例：{'userIds':'1001','goodsList':'[PyChildGoodsorder:{ids:'123',','goodsPrice':'10.00'}......]}")
	public ResponseInfo saveOrder(@RequestBody JSONObject json, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.saveOrder(json);
		return responseInfo;
	}
	/**
	 * 修改订单
	 * 修改子订单信息
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/add/order", method = RequestMethod.POST)
	@ApiOperation(value = "提交商品信息，修改保存订单", notes = "报文示例：{'userIds':'1001','goodsList':'[PyChildGoodsorder:{ids:'123',','goodsPrice':'10.00'}......]}")
	public ResponseInfo updateOrder(@RequestBody JSONObject json, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.updateOrder(json);
		return responseInfo;
	}

	/**
	 * 支付订单
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/pay/order", method = RequestMethod.POST)
	@ApiOperation(value = "对订单进行支付", notes = "报文示例：{'PyMainGoodsorder':'1001','userId':'chin'}")
	public ResponseInfo payOrder(@RequestBody PyMainGoodsorder pyMainGoodsorder , HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.payOrder(pyMainGoodsorder);
		return responseInfo;
	}
	
	/**
	 * 取消订单
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/cancel/order", method = RequestMethod.POST)
	@ApiOperation(value = "取消订单", notes = "报文示例：{'orderId':'1001','userId':'chin'}")
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.cancelOrder(pyBigGoodsorder);
		return responseInfo;
	}

	/**
	 * 查询订单列表
	 * 
	 * @param userids
	 * @return 修改参数 - 黄佳喜
	 */
	@RequestMapping(value = "/query/orderList", method = RequestMethod.POST)
	@ApiOperation(value = "查询订单", notes = "报文示例：{'userId':'chin'}")
	public ResponseInfo queryOrderListByUserId(String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.queryOrderListByUserId(userId);
		return responseInfo;
	}

}
