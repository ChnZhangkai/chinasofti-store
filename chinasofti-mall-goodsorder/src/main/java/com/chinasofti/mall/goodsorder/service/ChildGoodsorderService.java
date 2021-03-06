package com.chinasofti.mall.goodsorder.service;

import java.util.List;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.ChildorderCondition;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.goodsorder.handler.MyException;

import net.sf.json.JSONObject;

/**
* @ClassName: 	ChildGoodsorderService
* @Description: 子订单Service接口
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:23:16 
*/
public interface ChildGoodsorderService extends IBaseService<PyChildGoodsorder> {
	
	
	/**
	* @Title: selectByChildorderClass
	* @Description: 条件查询
	* @param childGoodsorder
	* @return JSONObject
	* @throws
	*/
	public JSONObject selectByChildorderClass(PyChildGoodsorder childGoodsorder);
	
	public JSONObject selectByChildorderCondition(ChildorderCondition childorderCondition);
	
	public List<PyChildGoodsorder> selectByMainorderIds(String mainorderIds);
	
	public int insertChildGoodsorderList(List<PyChildGoodsorder> childList) throws MyException;
	
	public ChnGoodsinfo selectGoodsInfo(String goodsId);
	
	public SpSendAddress queryAddress(String addressId);
	
	public List<PyChildGoodsorder> selectByUserIds(String userIds);
	
	public int updateStroe(ChnGoodsinfo chnGoodsinfo); 
	
	public List<PyChildGoodsorder> selectByBigOrderIds(String bigOrderIds);

	public int updateCancelGoodsNum(PyChildGoodsorder pyChildGoodsorder);
}
