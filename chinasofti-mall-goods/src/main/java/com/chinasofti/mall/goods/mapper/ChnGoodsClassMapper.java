package com.chinasofti.mall.goods.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample;

public interface ChnGoodsClassMapper {
    int countByExample(ChnGoodsClassExample example);

    int deleteByExample(ChnGoodsClassExample example);

    int deleteByPrimaryKey(String ids);

    int insert(ChnGoodsClass record);

    int insertSelective(ChnGoodsClass record);

    List<ChnGoodsClass> selectByExample(ChnGoodsClassExample example);

    ChnGoodsClass selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") ChnGoodsClass record, @Param("example") ChnGoodsClassExample example);

    int updateByExample(@Param("record") ChnGoodsClass record, @Param("example") ChnGoodsClassExample example);

    int updateByPrimaryKeySelective(ChnGoodsClass record);

    int updateByPrimaryKey(ChnGoodsClass record);
    
    List<ChnGoodsClass> findGoodsClass(String pids);
    /**
     * 根据相应Id查询分类
     * @param isParent
     * @return
     */
    List<ChnGoodsClass> selectByIsParent(@Param("isparent") String isparent);
    List<ChnGoodsClass> selectById(@Param("pids") String pids);
} 