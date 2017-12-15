package com.chinasofti.mall.batch.constants;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;

import java.util.ArrayList;
import java.util.List;


public class Constants {
	/**
	 * CancelGoodsOrdersJob 的入参
	 */
	public static final String PARAM_1 = "handleDate" ;
	/**
	 * 表示00:00:00
	 */
	public static final String TIME_PATTERN_1 = "000000" ;
	
	/**
	 * 支付状态
	 */
	public static final String PAY_STATUS_2 = "2" ;

	/**
	 * 保存主订单
	 */
	public static final List<PyMainGoodsorder> pyMainGoodsorderList = new ArrayList<PyMainGoodsorder>() ;

	/**
	 * 保存子订单
	 */
	public static final List<PyChildGoodsorder> pyChildGoodsorderList = new ArrayList<PyChildGoodsorder>() ;

	/**
	 * 保存商品
	 */
	public static final List<ChnGoodsinfo> chnGoodsinfoList = new ArrayList<ChnGoodsinfo>();
}
