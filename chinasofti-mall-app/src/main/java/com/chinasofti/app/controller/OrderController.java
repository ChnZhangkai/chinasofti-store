package com.chinasofti.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;

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
import com.chinasofti.app.feign.OrderFeignClient;
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
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	/**
	 * 删除订单
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ApiOperation(value = "删除订单", notes = "报文示例：{'orderId':'1001'}")
	public ResponseInfo deleteOrderById(@RequestParam("orderId") String orderId, HttpServletResponse response) {
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
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	//@ApiOperation(value="提交订单", notes="报文示例：{'userId':'chin','goodsId':'1001'}")
	public ResponseInfo saveOrder(@RequestBody JSONObject json,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ResponseInfo responseInfo = orderFeignClient.saveOrder(json);
		return responseInfo;
	}
	/**
	 * 修改订单
	 * 修改子订单信息
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
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
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
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
	@RequestMapping(value = "/cancel")
	@ApiOperation(value = "取消订单", notes = "报文示例：{'orderId':'020d900b821440dab33fc2d0a2615cf6'}")
	public ResponseInfo cancelOrder(@RequestParam("orderId") String orderId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.cancelOrder(orderId);
		return responseInfo;
	}

	/**
	 * 查询订单列表
	 * 
	 * @param userId
	 * @return 修改参数 - 黄佳喜
	 */
	@RequestMapping(value = "/list")
	@ApiOperation(value = "查询订单", notes = "报文示例：{'userId':'4619f8f622e94f38bb1a6f132c70d0b6'}")
	public ResponseInfo queryOrderListByUserId(@RequestParam("userId") String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		ResponseInfo responseInfo = orderFeignClient.queryOrderListByUserId(userId);
		return responseInfo;
	}

}
