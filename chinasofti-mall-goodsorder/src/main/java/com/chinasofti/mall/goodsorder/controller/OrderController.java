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

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.order.PyOrderInfo;
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
	 * 删除大订单 未付款前的订单删除
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del/big", method = RequestMethod.POST)
	@ApiOperation(value="删除订单", notes="报文示例：{'orderId':'1001','userId':'1001'}")
	public ResponseInfo deleteByBigOrderId(@RequestBody PyBigGoodsorder pyBigGoodsorder) {
		ResponseInfo responseInfo = orderService.deleteByBigOrderId(pyBigGoodsorder);
		return responseInfo;
	}
	/**
	 * 删除主订单 付款之后按照商家陈列删除订单商品信息
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del/main", method = RequestMethod.POST)
	@ApiOperation(value="删除订单", notes="报文示例：{'orderId':'1001','userId':'1001'}")
	public ResponseInfo deleteByMainOrderId(@RequestBody PyMainGoodsorder pyMainGoodsorder) {
		ResponseInfo responseInfo = orderService.deleteByMainOrderId(pyMainGoodsorder);
		return responseInfo;
	}
	
	/**
	 * 提交订单
	 * @param t
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ResponseInfo saveOrder(@RequestBody PyOrderInfo orderInfo) {
		logger.info("*******************1*********************");
		ResponseInfo responseInfo = orderService.saveOrder(orderInfo);
		return responseInfo;
	}

	/**
	 * 支付订单
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/pay", method = RequestMethod.POST)
	@ApiOperation(value="支付订单", notes= "报文示例：{'transactionid':'1001','userId':'abc123','ids':'abc123'}")
	public ResponseInfo payOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder) {
		ResponseInfo responseInfo = orderService.payOrder(pyBigGoodsorder);
		return responseInfo;
	}
	/**
	 * 取消订单
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/cancel", method = RequestMethod.POST)
	@ApiOperation(value="取消订单", notes="报文示例：{'bigorderId': '2016081117540600001332','ids': '2bd9c1371f3740e68d44ca4704bb153b','userIds': '2ece18eab354480b928ce91d5f3813f0'}")
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder) {
		ResponseInfo responseInfo = orderService.cancelOrder(pyBigGoodsorder);
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

	
	/**
	 * 删除主订单 付款之后按照商家陈列删除订单商品信息
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	@ApiOperation(value="主订单", notes="报文示例：{'orderId':'1001','userId':'1001'}")
	public ResponseInfo queryMainOrderList(@RequestBody PyMainGoodsorder pyMainGoodsorder) {
		ResponseInfo responseInfo = orderService.queryMainOrderList(pyMainGoodsorder);
		return responseInfo;
	}
}
