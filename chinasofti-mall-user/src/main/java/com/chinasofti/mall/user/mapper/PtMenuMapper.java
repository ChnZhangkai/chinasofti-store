package com.chinasofti.mall.user.mapper;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.PtMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PtMenuMapper {
    int countByExample(PtMenuExample example);

    int deleteByExample(PtMenuExample example);

    int insert(PtMenu record);

    int insertSelective(PtMenu record);

    List<PtMenu> selectByExample(PtMenuExample example);

    int updateByExampleSelective(@Param("record") PtMenu record, @Param("example") PtMenuExample example);

    int updateByExample(@Param("record") PtMenu record, @Param("example") PtMenuExample example);

	PtMenu selectByPrimaryKey(String id);
	
	List<PtMenu> selectByPid(String pid);

	int updateByPrimaryKeySelective(PtMenu ptMenu);

	int deleteByPrimaryKey(String ids);
}