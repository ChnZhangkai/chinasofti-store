/**
 * 
 */
package com.chinasofti.mall.goods.mapper;
 
import java.util.List;

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
	int updateByPrimaryKeySelective(ChnGoodsOnline chnGoodsOnline);

}
