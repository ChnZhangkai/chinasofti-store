package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 服务之间互相访问订单工程
 * @author heruilong
 * 
 */
@FeignClient(name="goodsorder-service")
public interface OrderFeignClient {

	@RequestMapping(value="/order/V1.0/query/orderList", method = RequestMethod.POST)
	public ResponseInfo queryOrderListByUserId(@RequestBody String userId);
	
	@RequestMapping(value="/order/V1.0/add/order", method = RequestMethod.POST)
	public ResponseInfo saveOrder(@RequestBody JSONObject json);

	@RequestMapping(value="/order/V1.0/pay/order", method = RequestMethod.POST)
	public ResponseInfo payOrder(@RequestBody PyMainGoodsorder pyMainGoodsorder);
	
	@RequestMapping(value="/order/V1.0/cancel/order", method = RequestMethod.POST)
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder);
	
	@RequestMapping(value="/order/V1.0/del/order", method = RequestMethod.POST)
	public ResponseInfo deleteOrderById(@RequestBody String orderId);

	@RequestMapping(value="/order/V1.0/update/order", method = RequestMethod.POST)
	public ResponseInfo updateOrder(JSONObject json);
}
