package com.chinasofti.mall.web.entrance.mapper;

import com.chinasofti.mall.common.entity.goods.GoodsFile;
import com.chinasofti.mall.common.entity.goods.GoodsFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsFileMapper {
    int countByExample(GoodsFileExample example);

    int deleteByExample(GoodsFileExample example);

    int deleteByPrimaryKey(String ids);

    int insert(GoodsFile record);

    int insertSelective(GoodsFile record);

    List<GoodsFile> selectByExample(GoodsFileExample example);

    GoodsFile selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") GoodsFile record, @Param("example") GoodsFileExample example);

    int updateByExample(@Param("record") GoodsFile record, @Param("example") GoodsFileExample example);

    int updateByPrimaryKeySelective(GoodsFile record);

    int updateByPrimaryKey(GoodsFile record);
}