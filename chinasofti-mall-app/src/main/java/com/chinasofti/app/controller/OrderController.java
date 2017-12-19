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
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.OrderFeignClient;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.order.PyOrderInfo;
import com.chinasofti.mall.common.utils.MsgEnum;
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
	 * 删除大订单 未付款前的订单删除
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del/big", method = RequestMethod.POST)
	@ApiOperation(value = "删除大订单(未支付前删除)", notes = "报文示例：{'ids':'615effad51604988920e1da779ff19e3','userIds': '2ece18eab354480b928ce91d5f3813f0','transactionid':'2016081816222600001390'}")
	public ResponseInfo deleteByBigOrderId(@RequestBody PyBigGoodsorder pyBigGoodsorder, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		if (null == pyBigGoodsorder.getUserIds() || pyBigGoodsorder.getUserIds().trim().equals("")) {
			ResponseInfo info = new ResponseInfo();
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg("userId不能为空");
			return info;
		}
		ResponseInfo responseInfo = orderFeignClient.deleteByBigOrderId(pyBigGoodsorder);
		logger.debug("delete" + pyBigGoodsorder.getIds());
		return responseInfo;
	}
	/**
	 * 删除主订单 付款之后按照商家陈列删除订单商品信息
	 * 只做订单状态修改，并没有删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del/main", method = RequestMethod.POST)
	@ApiOperation(value = "删除主订单（支付后删除）", notes = "报文示例：{'bigorderId': '2016081116361500001329','ids': 'edd0d62ab11543e492978cb0a6447582','userIds': '2ece18eab354480b928ce91d5f3813f0'}")
	public ResponseInfo deleteByMainOrderId(@RequestBody PyMainGoodsorder pyMainGoodsorder, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		if (null == pyMainGoodsorder.getUserIds() || pyMainGoodsorder.getUserIds().trim().equals("")) {
			ResponseInfo info = new ResponseInfo();
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg("userId不能为空");
			return info;
		}
		ResponseInfo responseInfo = orderFeignClient.deleteByMainOrderId(pyMainGoodsorder);
		return responseInfo;
	}

	/**
	 * 提交订单
	 * 保存子订单信息，生成大订单，主订单
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ApiOperation(value="提交订单", notes="报文示例：{'userIds':'chin','goodsId':'1001'}")
	public ResponseInfo saveOrder(@RequestBody PyOrderInfo orderInfo,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ResponseInfo responseInfo = orderFeignClient.saveOrder(orderInfo);
		return responseInfo;
	}

	/**
	 * 支付订单
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ApiOperation(value = "对订单进行支付", notes = "报文示例：{'transactionid':'1001','userId':'abc123','ids':'abc123'}")
	public ResponseInfo payOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		if (null == pyBigGoodsorder.getUserIds() || pyBigGoodsorder.getUserIds().trim().equals("")) {
			ResponseInfo info = new ResponseInfo();
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg("userId不能为空");
			return info;
		}
		ResponseInfo responseInfo = orderFeignClient.payOrder(pyBigGoodsorder);
		return responseInfo;
	}
	
	/**
	 * 取消订单
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ApiOperation(value = "取消订单（未支付取消）", notes = "报文示例：{'ids':'6cd0db1b21884651950b1c9b236bd3d0','transactionid':'2016081011311100001307','userIds':'2ece18eab354480b928ce91d5f3813f0'}")
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		if (null == pyBigGoodsorder.getUserIds() || pyBigGoodsorder.getUserIds().trim().equals("")) {
			ResponseInfo info = new ResponseInfo();
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg("userId不能为空");
			return info;
		}
		ResponseInfo responseInfo = orderFeignClient.cancelOrder(pyBigGoodsorder);
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
		if (null == userId || userId.trim().equals("")) {
			ResponseInfo info = new ResponseInfo();
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg("userId不能为空");
			return info;
		}
		ResponseInfo responseInfo = orderFeignClient.queryOrderListByUserId(userId);
		return responseInfo;
	}
	/**
	 * 查询订单列表
	 * 
	 * @param userId
	 * @return 修改参数 - 黄佳喜
	 */
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	@ApiOperation(value = "查询订单", notes = "报文示例：{'userIds':'abc123','pageNumber':'1','pageSize':'3'}")
	public ResponseInfo queryMainOrderList(@RequestBody PyMainGoodsorder pyMainGoodsorder, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		if (null == pyMainGoodsorder.getUserIds() || pyMainGoodsorder.getUserIds().trim().equals("")) {
			ResponseInfo info = new ResponseInfo();
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg("userId不能为空");
			return info;
		}
		ResponseInfo responseInfo = orderFeignClient.queryMainOrderList(pyMainGoodsorder);
		return responseInfo;
	}

	
}
