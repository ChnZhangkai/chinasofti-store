package com.chinasofti.mall.goodsorder.mapper;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.ChildorderCondition;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorderExample;
import com.chinasofti.mall.common.entity.spuser.SpSendAddress;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyChildGoodsorderMapper {
    int countByExample(PyChildGoodsorderExample example);

    int deleteByExample(PyChildGoodsorderExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PyChildGoodsorder record);

    int insertSelective(PyChildGoodsorder record);

    List<PyChildGoodsorder> selectByExample(PyChildGoodsorderExample example);

    PyChildGoodsorder selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PyChildGoodsorder record, @Param("example") PyChildGoodsorderExample example);

    int updateByExample(@Param("record") PyChildGoodsorder record, @Param("example") PyChildGoodsorderExample example);

    int updateByPrimaryKeySelective(PyChildGoodsorder record);

    int updateByPrimaryKey(PyChildGoodsorder record);
    
    List<PyChildGoodsorder> selectByChildorderCondition(ChildorderCondition childorderCondition);
 
    //商品库存数量
    BigDecimal selectGoodsNum(String goodsId);
    //收件地址ID
    SpSendAddress selectAddress(String addressId);
    
    //更新库存
    int updateStore(ChnGoodsinfo chnGoodsinfo);

    List<PyChildGoodsorder> selectByBigOrderIds(String bigOrderIds);

	int updateCancelGoodsNum(PyChildGoodsorder pyChildGoodsorder);
}