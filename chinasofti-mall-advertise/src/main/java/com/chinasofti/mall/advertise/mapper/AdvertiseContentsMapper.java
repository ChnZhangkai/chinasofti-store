package com.chinasofti.mall.advertise.mapper;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertiseContentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}