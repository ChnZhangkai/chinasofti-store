package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.OrderFeignClientHystrix;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.order.PyOrderInfo;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 服务之间互相访问订单工程
 * 
 */
@FeignClient(name="goodsorder-service",fallback =OrderFeignClientHystrix.class)
public interface OrderFeignClient {

	@RequestMapping(value="/order/list")
	public ResponseInfo queryOrderListByUserId(@RequestParam("userId") String userId);
	
	@RequestMapping(value="/order/add", method = RequestMethod.POST)
	public ResponseInfo saveOrder(@RequestBody PyOrderInfo orderInfo);

	@RequestMapping(value="/order/pay", method = RequestMethod.POST)
	public ResponseInfo payOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder);
	
	@RequestMapping(value="/order/cancel", method = RequestMethod.POST)
	public ResponseInfo cancelOrder(@RequestBody PyBigGoodsorder pyBigGoodsorder);
	
	@RequestMapping(value="/order/del/big", method = RequestMethod.POST)
	public ResponseInfo deleteByBigOrderId(@RequestBody PyBigGoodsorder pyBigGoodsorder);

	@RequestMapping(value="/order/del/main", method = RequestMethod.POST)
	public ResponseInfo deleteByMainOrderId(@RequestBody PyMainGoodsorder pyMainGoodsorder);
	
	@RequestMapping(value="/order/main", method = RequestMethod.POST)
	public ResponseInfo queryMainOrderList(@RequestBody PyMainGoodsorder pyMainGoodsorder);
}
