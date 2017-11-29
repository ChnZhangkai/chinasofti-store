package com.chinasofti.app.hystrix;


import org.springframework.stereotype.Component;
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
public class OrderFeignClientHystrix implements OrderFeignClient{
	

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


	@Override
	public ResponseInfo cancelOrder(String orderId) {
		return null;
	}

	

	
}
