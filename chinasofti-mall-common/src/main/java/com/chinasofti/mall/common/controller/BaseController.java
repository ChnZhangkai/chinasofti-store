package com.chinasofti.mall.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;



/**
 * 
* @ClassName: BaseController
* @Description: 公共controller
* @author kanmeng
* @date 2017年11月1日 上午12:08:42 
* @param <T>
 */
public interface BaseController<T> {
	
	//public abstract String getPath();
	
	//public abstract IBaseService<T> getService();
	
	public List<T> findAll( );
	
	public T findById(@PathVariable String id);
	
	public String deleteById(@PathVariable String id);
	
	public String update(T t);
	
	public String add(T t);
}
