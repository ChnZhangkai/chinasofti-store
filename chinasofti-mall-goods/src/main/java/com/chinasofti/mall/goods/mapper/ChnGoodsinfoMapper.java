package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChnGoodsinfoMapper {
    int countByExample(ChnGoodsinfoExample example);

    int deleteByExample(ChnGoodsinfoExample example);

    int deleteByPrimaryKey(String ids);

    int insert(ChnGoodsinfo record);

    int insertSelective(ChnGoodsinfo record);

    List<ChnGoodsinfo> selectByExample(ChnGoodsinfoExample example);

    ChnGoodsinfo selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") ChnGoodsinfo record, @Param("example") ChnGoodsinfoExample example);

    int updateByExample(@Param("record") ChnGoodsinfo record, @Param("example") ChnGoodsinfoExample example);

    int updateByPrimaryKeySelective(ChnGoodsinfo record);

    int updateByPrimaryKey(ChnGoodsinfo record);
    /**
     * 根据分类Id查询商品信息
     * @param goodsClassIds
     * @return
     */
    List<ChnGoodsinfo> selectByClassId(String goodsClassIds);
    
}