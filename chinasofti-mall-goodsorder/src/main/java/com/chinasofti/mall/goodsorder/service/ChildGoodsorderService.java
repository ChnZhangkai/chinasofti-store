package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import com.chinasofti.mall.common.entity.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.PyChildGoodsorderExample;
import com.chinasofti.mall.common.service.IBaseService;

/**
* @ClassName: 	ChildGoodsorderService
* @Description: 子订单Service接口
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:23:16 
*/
public interface ChildGoodsorderService extends IBaseService<PyChildGoodsorder> {
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param @param example
	* @param @return    参数
	* @return List<PyChildGoodsorder>    返回类型
	* @throws
	*/
	public List<PyChildGoodsorder> selectByExample(PyChildGoodsorderExample example);

}
