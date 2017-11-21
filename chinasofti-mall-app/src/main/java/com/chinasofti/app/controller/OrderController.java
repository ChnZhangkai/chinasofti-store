package com.chinasofti.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.app.feign.OrderFeignClient;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.netflix.client.http.HttpResponse;

/**
 * 订单
 * @author heruilong
 *
 */
@Controller
@RequestMapping("/order")
@Api(value = "OrderController", description = "订单-API")
public class OrderController {
	
	@Autowired
	private OrderFeignClient orderFeignClient;
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/del/order", method = RequestMethod.POST)
	@ApiOperation(value="删除订单", notes="报文示例：{'orderId':'1001'}")
	public ResponseInfo deleteOrderById(@RequestBody JSONObject json,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = orderFeignClient.deleteOrderById(json);
		return responseInfo;
	}
	
	/**
	 * 提交订单
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add/order", method = RequestMethod.POST)
	@ApiOperation(value="提交订单", notes="报文示例：{'userId':'chin','goodsId':'1001'}")
	public ResponseInfo saveOrder(@RequestBody JSONObject json,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = orderFeignClient.saveOrder(json);
		return responseInfo;
	}

	/**
	 * 取消订单
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cancel/order", method = RequestMethod.POST)
	@ApiOperation(value="取消订单", notes="报文示例：{'ids':'1','orderId':'1001','userId':'chin'}")
	public ResponseInfo cancelOrder(@RequestBody JSONObject json,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = orderFeignClient.cancelOrder(json);
		return responseInfo;
	}
	
	/**
	 * 查询订单列表
	 * @param json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/query/orderList", method = RequestMethod.POST)
	@ApiOperation(value="查询订单", notes="报文示例：{'orderId':'1001','userId':'chin'}")
	public ResponseInfo queryOrderListByUserId(@RequestBody JSONObject json,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = orderFeignClient.queryOrderListByUserId(json);
		return responseInfo;
	}


}
