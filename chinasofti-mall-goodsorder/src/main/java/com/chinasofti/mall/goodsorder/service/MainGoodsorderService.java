package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;

/**
* @ClassName: 	MainGoodsorderService
* @Description: 主订单Service接口
*
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 上午10:20:50 
*
*/
public interface MainGoodsorderService extends IBaseService<PyMainGoodsorderWithBLOBs> {
	
	/**
	* @Title: selectByExample
	* @Description: 条件查询
	* @param @param example
	* @param @return    参数
	* @return List<PyMainGoodsorderWithBLOBs>    返回类型
	* @throws
	*/
	public List<PyMainGoodsorderWithBLOBs> selectByExample(PyMainGoodsorderExample example);

}
