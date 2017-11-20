package com.chinasofti.mall.goodsorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goodsorder.service.OrderService;

/**
 * 订单工程
 * @author heruilong
 *
 */
@Controller
@RequestMapping("/order/V1.0")
@Api(value = "OrderController", description = "订单工程-API")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/del/order", method = RequestMethod.POST)
	@ApiOperation(value="删除订单", notes="报文示例：{'orderId':'1001'}")
	public ResponseInfo deleteOrderById( String orderId) {
		ResponseInfo responseInfo = orderService.deleteOrderById(orderId);
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
	public ResponseInfo saveOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder) {
		ResponseInfo responseInfo = orderService.saveOrder(pyBigGoodsorder);
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
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder) {
		ResponseInfo responseInfo = orderService.cancelOrder( pyBigGoodsorder);
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
	public ResponseInfo queryOrderListByUserId(@RequestBody String userId){
		ResponseInfo responseInfo = orderService.queryOrderListByUserId(userId);
		return responseInfo;
	}


}
