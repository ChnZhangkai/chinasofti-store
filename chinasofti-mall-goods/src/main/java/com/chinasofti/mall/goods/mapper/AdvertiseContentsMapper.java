package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertiseContentsExample;
import com.chinasofti.mall.common.entity.AdvertisePosition;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdvertiseContentsMapper {
    int countByExample(AdvertiseContentsExample example);

    int deleteByExample(AdvertiseContentsExample example);

    int deleteByPrimaryKey(String ids);

    int insert(AdvertiseContents record);

    int insertSelective(AdvertiseContents record);

    List<AdvertiseContents> selectByExample(AdvertiseContentsExample example);

    AdvertiseContents selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") AdvertiseContents record, @Param("example") AdvertiseContentsExample example);

    int updateByExample(@Param("record") AdvertiseContents record, @Param("example") AdvertiseContentsExample example);

    int updateByPrimaryKeySelective(AdvertiseContents record);

    int updateByPrimaryKey(AdvertiseContents record);

	int pubOrCanAdvertise(Map<String, Object> map);
	//根据位置Id查询广告列表
    List<AdvertiseContents> selectAdvertiseList(String positionId);
    
    AdvertiseContents selectSingleAdvertise(String positionId);
    
   List<AdvertisePosition> findAdPostionAll();
}