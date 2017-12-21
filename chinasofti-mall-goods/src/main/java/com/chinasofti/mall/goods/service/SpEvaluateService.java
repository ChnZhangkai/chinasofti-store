/**
 * 
 */
package com.chinasofti.mall.goods.service;

import java.util.Map;

import com.chinasofti.mall.common.entity.goods.SpEvaluate;

/**
 * @ClassName: GoodsCommentsService.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年12月20日 下午5:05:41
 * @parma <T>
 */
public interface SpEvaluateService {

	Map<String, Object> findByCommentsPage(Map<String, Object> map);

	int deleteById(String id);

	SpEvaluate selectByCommentsIds(String ids);

}
