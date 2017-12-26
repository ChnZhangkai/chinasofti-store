/**
 * 
 */
package com.chinasofti.mall.goods.mapper;
 
import java.util.List;
import java.util.Map;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;

/**
 * @ClassName: ChnGoodsOnlineMapper.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月10日 下午4:00:52
 * @parma <T>
 */
public interface ChnGoodsOnlineMapper {

	/**
	 * @param chnGoodsOnline
	 * @return
	 */
	List<ChnGoodsOnline> findAll(ChnGoodsOnline chnGoodsOnline);

	/**
	 * @param chnGoodsOnline
	 * @return
	 */
	int updateByPrimaryKey(ChnGoodsOnline chnGoodsOnline);


	/**
	 * @param chnGoodsOnline
	 * @return
	 */
	int update(ChnGoodsOnline chnGoodsOnline);

	/**
	 * @param paramMap
	 * @return
	 */
	List<ChnGoodsOnline> findByPage(Map<String, Object> paramMap);
	
	/**
	 * 修改,过滤空字段
	 * @param chnGoodsOnline
	 * @return
	 */
	int updateByPrimaryKeySelective(ChnGoodsOnline chnGoodsOnline);
	
	/**
	 * 通过id查询
	 * @param ids
	 * @return
	 */
	ChnGoodsOnline selectByPrimaryKey(String ids);
}
