package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 服务之间互相访问订单工程
 * 
 */
@FeignClient(name="goodsorder-service")
public interface OrderFeignClient {

	@RequestMapping(value="/order/list")
	public ResponseInfo queryOrderListByUserId(@RequestParam("userId") String userId);
	
	@RequestMapping(value="/order/add", method = RequestMethod.POST)
	public ResponseInfo saveOrder(@RequestBody JSONObject json);

	@RequestMapping(value="/order/pay", method = RequestMethod.POST)
	public ResponseInfo payOrder(@RequestBody PyMainGoodsorder pyMainGoodsorder);
	
	@RequestMapping(value="/order/cancel")
	public ResponseInfo cancelOrder(@RequestParam("orderId") String orderId);
	
	@RequestMapping(value="/order/del")
	public ResponseInfo deleteOrderById(@RequestParam("orderId") String orderId);

	@RequestMapping(value="/order/update", method = RequestMethod.POST)
	public ResponseInfo updateOrder(JSONObject json);
}
