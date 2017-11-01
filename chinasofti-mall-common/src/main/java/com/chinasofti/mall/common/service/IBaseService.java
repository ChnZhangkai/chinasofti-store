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
	
	public T save(T t);
	
	public List<T> findAll();
	
	public T findById(String id);
	
	public int deleteById(String id);
	
	public int update(T t);
	
}
