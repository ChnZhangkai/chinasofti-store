package com.chinasofti.mall.goodsorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goodsorder.service.OrderService;

/**
 * 订单工程
 * @author heruilong
 *
 */
@RestController
@RequestMapping("/order")
@Api(value = "OrderController", description = "订单工程-API")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ApiOperation(value="删除订单", notes="报文示例：{'orderId':'1001'}")
	public ResponseInfo deleteOrderById(@RequestParam("orderId") String orderId) {
		ResponseInfo responseInfo = orderService.deleteOrderById(orderId);
		return responseInfo;
	}
	
	/**
	 * 提交订单
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ResponseInfo saveOrder(@RequestBody JSONObject json) {
		logger.info("*******************1*********************");
		ResponseInfo responseInfo = orderService.saveOrder(json);
		return responseInfo;
	}

	/**
	 * 支付订单
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/pay", method = RequestMethod.POST)
	@ApiOperation(value="支付订单", notes="报文示例：{'orderId':'1001','userId':'chin'}")
	public ResponseInfo payOrder(@RequestBody PyMainGoodsorder pyMainGoodsorder) {
		ResponseInfo responseInfo = orderService.payOrder(pyMainGoodsorder);
		return responseInfo;
	}
	/**
	 * 取消订单
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/cancel", method = RequestMethod.POST)
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
	@RequestMapping(value="/list")
	@ApiOperation(value="查询订单", notes="报文示例：{'userId':'4619f8f622e94f38bb1a6f132c70d0b6'}")
	public ResponseInfo queryOrderListByUserId(@RequestParam("userId") String userId){
		ResponseInfo responseInfo = orderService.queryOrderListByUserId(userId);
		return responseInfo;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResponseInfo updateOrder(JSONObject json) {
		ResponseInfo responseInfo = orderService.updateOrder(json);
		return responseInfo;
	}

}
