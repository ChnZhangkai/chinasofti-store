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

import com.chinasofti.app.feign.OrderFeignClient;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;

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
	public ResponseInfo deleteOrderById( String  orderId,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = orderFeignClient.deleteOrderById(orderId);
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
	public ResponseInfo saveOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		
		ResponseInfo responseInfo = orderFeignClient.saveOrder(pyBigGoodsorder);
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
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");

		ResponseInfo responseInfo = orderFeignClient.cancelOrder(pyBigGoodsorder);
		return responseInfo;
	}
	
	/**
	 * 查询订单列表
	 * @param json
	 * @return
	 * 修改参数 - 黄佳喜
	 */
	@ResponseBody
	@RequestMapping(value="/query/orderList", method = RequestMethod.POST)
	@ApiOperation(value="查询订单", notes="报文示例：{'orderId':'1001','userId':'chin'}")
	public ResponseInfo queryOrderListByUserId( String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		ResponseInfo responseInfo = orderFeignClient.queryOrderListByUserId(userId);
		return responseInfo;
	}


}
