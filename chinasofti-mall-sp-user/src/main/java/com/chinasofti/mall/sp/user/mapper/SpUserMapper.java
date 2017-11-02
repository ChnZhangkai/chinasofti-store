package com.chinasofti.mall.sp.user.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.common.entity.SpUserExample;

/**
 * @ClassName: SpUserMapper.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:10:17
 * @parma <T>
 */
public interface SpUserMapper {

	   int countByExample(SpUserExample example);

	    int deleteByExample(SpUserExample example);

	    int deleteByPrimaryKey(String ids);

	    int insert(SpUser record);

	    int insertSelective(SpUser record);

	    List<SpUser> selectByExample(SpUserExample example);

	    SpUser selectByPrimaryKey(String ids);

	    int updateByExampleSelective(@Param("record") SpUser record, @Param("example") SpUserExample example);

	    int updateByExample(@Param("record") SpUser record, @Param("example") SpUserExample example);

	    int updateByPrimaryKeySelective(SpUser record);

	    int updateByPrimaryKey(SpUser record);
}
