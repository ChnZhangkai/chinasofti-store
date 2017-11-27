package com.chinasofti.app.hystrix;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.controller.OrderController;
import com.chinasofti.app.feign.OrderFeignClient;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.alibaba.fastjson.JSONObject;

/**
 * 
* @ClassName: OrderrFeignClientHystrix
* @Description: 熔断类
* @author xiaozhiliang
* @date 2017年11月9日 
* @version
 */
@Component
public class OrderrFeignClientHystrix implements OrderFeignClient{
	

	@Override
	public ResponseInfo queryOrderListByUserId(String userId) {
		return new ResponseInfo();
	}
	
 
	@Override
	public ResponseInfo saveOrder(JSONObject json){
		return new ResponseInfo();
	}
	
	public ResponseInfo payOrder(PyMainGoodsorder pyMainGoodsorder){
		return new ResponseInfo();
	}
	
	public ResponseInfo cancelOrder(PyBigGoodsorder pyBigGoodsorder){
		return new ResponseInfo();
	}
	
	public ResponseInfo deleteOrderById(String orderId){
		return new ResponseInfo();
	}

	public ResponseInfo updateOrder(JSONObject json){
		return new ResponseInfo();
	}

	

	
}
