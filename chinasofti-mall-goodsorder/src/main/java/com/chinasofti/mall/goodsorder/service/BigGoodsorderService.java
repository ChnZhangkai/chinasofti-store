package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorderExample;
import com.chinasofti.mall.common.service.IBaseService;


/**
* @ClassName: 	BigGoodsorderService
* @Description: 大订单service接口
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:21:29 
*/
public interface BigGoodsorderService extends IBaseService<PyBigGoodsorder> {
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param @param example
	* @param @return    参数
	* @return List<PyBigGoodsorder>    返回类型
	* @throws
	*/
	public List<PyBigGoodsorder> selectByExample(PyBigGoodsorderExample example);

	PyBigGoodsorder selectByIds(String ids);
	
	public List<PyBigGoodsorder> selectByUserIds(String userId);

	public int updateByMainOrder(String bigorderId);
	
	public int countOrderNO(String orderNo);
}
