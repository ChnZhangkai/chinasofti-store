package com.chinasofti.mall.batch.mapper;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import org.apache.ibatis.annotations.Param;

/**
 * @Author yedawang
 * @Date 2017-12-12 23:27
 */
public interface ChnGoodsInfoMapper {

    /**
     * 根据子订单检索相应的商品信息
     * @param pyChildGoodsorder
     * @return
     */
    ChnGoodsinfo findGoodsInfoByChildOrder(@Param("pyChildGoodsorder") PyChildGoodsorder pyChildGoodsorder) ;

    /**
     * 更新商品信息
     * @param chnGoodsinfo
     */
    void updateChnGoodsInfo(@Param("chnGoodsinfo") ChnGoodsinfo  chnGoodsinfo) ;

}
