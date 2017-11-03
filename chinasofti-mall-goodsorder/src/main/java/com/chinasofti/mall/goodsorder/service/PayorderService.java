package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import com.chinasofti.mall.common.entity.PyPayorder;
import com.chinasofti.mall.common.entity.PyPayorderExample;
import com.chinasofti.mall.common.service.IBaseService;


/**
* @ClassName: 	PayorderService
* @Description: 支付订单Service接口
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:25:39 
*/
public interface PayorderService extends IBaseService<PyPayorder> {
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param @param example
	* @param @return    参数
	* @return List<PyPayorder>    返回类型
	* @throws
	*/
	public List<PyPayorder> selectByExample(PyPayorderExample example);

}
