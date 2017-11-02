package com.chinasofti.mall.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chinasofti.mall.common.service.IBaseService;



/**
 * 
* @ClassName: BaseController
* @Description: 公共controller
* @author kanmeng
* @date 2017年11月1日 上午12:08:42 
* @param <T>
 */
public abstract class BaseController<T> {
	
	//public abstract String getPath();
	
	public abstract IBaseService<T> getService();
	
	@RequestMapping("findAll")
	public List<T> findAll( ) {
		return getService().findAll();
	}
	

	@RequestMapping("findById/{id}")
	public T findById(@PathVariable String id) {
		return getService().findById(id);
	}
	

	@RequestMapping("deleteById/{id}")
	public int deleteById(@PathVariable String id) {
		return getService().deleteById(id);
	}
	

	@RequestMapping("update")
	public int update(T t){
		return getService().update(t);
	}
	
	@RequestMapping("add")
	public int add(T t){
		return getService().save(t);
	}
}
