package com.chinasofti.mall.batch.mapper;

import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;

import java.util.List;

/**
 * @Author yedawang
 * @Date 2017-12-12 23:08
 */
public interface PyChildGoodsOrderMapper {
    /**
     * 通过主订单号查询子订单
     * @return
     */
    List<PyChildGoodsorder> findListByMainId(List<PyMainGoodsorder> list) ;
}
