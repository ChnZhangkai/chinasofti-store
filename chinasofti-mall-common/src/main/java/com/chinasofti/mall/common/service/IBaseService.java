package com.chinasofti.mall.common.service;

import java.util.List;

/**
 * 
 * @ClassName: IBaseService
 * @Description: 公共service
 * @author kanmeng
 * @date 2017年11月1日 下午12:25:28
 * @param <T>
 */
public interface IBaseService<T> {
	// 增加
	public int save(T t);

	// 查詢全部
	public List<T> findAll();

	// 根据id查询
	public T findById(String id);

	// 根据id删除
	public int deleteById(String id);

	// 更新
	public int update(T t);
}
