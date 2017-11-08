package com.chinasofti.mall.user.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUserExample;

/**
 * @ClassName: SpUserMapper.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:10:17
 * @parma <T>
 */
public interface SpMerchantUserMapper {

	   int countByExample(SpMerchantUserExample example);

	    int deleteByExample(SpMerchantUserExample example);

	    int deleteByPrimaryKey(String ids);

	    int insert(SpMerchantUser record);

	    int insertSelective(SpMerchantUser record);

	    List<SpMerchantUser> selectByExample(SpMerchantUserExample example);

	    SpMerchantUser selectByPrimaryKey(String ids);

	    int updateByExampleSelective(@Param("record") SpMerchantUser record, @Param("example") SpMerchantUserExample example);

	    int updateByExample(@Param("record") SpMerchantUser record, @Param("example") SpMerchantUserExample example);

	    int updateByPrimaryKeySelective(SpMerchantUser record);

	    int updateByPrimaryKey(SpMerchantUser record);
}
