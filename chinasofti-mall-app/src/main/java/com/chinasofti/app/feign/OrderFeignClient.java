package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 访问订单工程
 * @author heruilong
 *
 */
@FeignClient(name="goodsorder-service")
public interface OrderFeignClient {

	@ResponseBody
	@RequestMapping(value="/order/V1.0/query/orderList", method = RequestMethod.POST)
	public ResponseInfo queryOrderListByUserId(@RequestBody JSONObject json);
	
	@ResponseBody
	@RequestMapping(value="/order/V1.0/add/order", method = RequestMethod.POST)
	public ResponseInfo saveOrder(@RequestBody JSONObject json);

	@ResponseBody
	@RequestMapping(value="/order/V1.0/cancel/order", method = RequestMethod.POST)
	public ResponseInfo cancelOrder(@RequestBody JSONObject json);
	
	@ResponseBody
	@RequestMapping(value="/order/V1.0/del/order", method = RequestMethod.POST)
	public ResponseInfo deleteOrderById(@RequestBody JSONObject json);
}
