package com.chinasofti.mall.advertise.mapper;

import com.chinasofti.mall.common.entity.CmsAdContents;
import com.chinasofti.mall.common.entity.CmsAdContentsExample;
import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsAdContentsMapper {
    int countByExample(CmsAdContentsExample example);

    int deleteByExample(CmsAdContentsExample example);

    int deleteByPrimaryKey(String ids);

    int insert(CmsAdContentsWithBLOBs record);

    int insertSelective(CmsAdContentsWithBLOBs record);

    List<CmsAdContentsWithBLOBs> selectByExampleWithBLOBs(CmsAdContentsExample example);

    List<CmsAdContents> selectByExample(CmsAdContentsExample example);

    CmsAdContentsWithBLOBs selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") CmsAdContentsWithBLOBs record, @Param("example") CmsAdContentsExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsAdContentsWithBLOBs record, @Param("example") CmsAdContentsExample example);

    int updateByExample(@Param("record") CmsAdContents record, @Param("example") CmsAdContentsExample example);

    int updateByPrimaryKeySelective(CmsAdContentsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CmsAdContentsWithBLOBs record);

    int updateByPrimaryKey(CmsAdContents record);
    
    int fackDelete(String id);
}