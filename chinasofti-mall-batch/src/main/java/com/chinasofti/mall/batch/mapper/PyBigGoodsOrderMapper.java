package com.chinasofti.mall.batch.mapper;

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yedawang
 * @Date 2017-12-15 10:19
 */
public interface PyBigGoodsOrderMapper {
    /**
     * 查询7天内未支付的订单
     * @param beginTime
     * @param endTime
     * @return
     */
    List<PyBigGoodsorder> selectOrderNotPay(@Param("beginTime") String beginTime , @Param("endTime")String endTime) ;
    /**
     * 更新7天内未支付的订单的状态为：已取消-2
     * @param order
     */
    void updatePaywayStatus(@Param("order") PyBigGoodsorder order) ;
}
