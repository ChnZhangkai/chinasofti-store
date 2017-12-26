package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.GoodsPrefectureExample;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPrefectureMapper {
    int countByExample(GoodsPrefectureExample example);

    int deleteByExample(GoodsPrefectureExample example);

    int deleteByPrimaryKey(String ids);
    
    int deleteGoods(String goodsids);

    int insert(GoodsPrefecture record);

    int insertSelective(GoodsPrefecture record);
    
    List<GoodsPrefecture> selectByExample(GoodsPrefectureExample example);
    
    List<GoodsPrefecture> findAll();
    
    List<ChnGoodsOnline> findGoodsById(String ids);

    List<GoodsPrefecture> selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") GoodsPrefecture record, @Param("example") GoodsPrefectureExample example);

    int updateByExample(@Param("record") GoodsPrefecture record, @Param("example") GoodsPrefectureExample example);

    int updateByPrimaryKeySelective(GoodsPrefecture record);

    int updateByPrimaryKey(GoodsPrefecture record);
}