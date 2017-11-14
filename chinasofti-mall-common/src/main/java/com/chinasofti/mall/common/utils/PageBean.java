package com.chinasofti.mall.common.utils;

public class PageBean {
	
	//总条数
	private int total;
	//每页显示数据
	private int pageSize;
	//当前页码
	private int pageNumber;
	
	/**
	* @Fields page : 使用easyUI默认datagrid属性时的当前页面
	*/
	private int page;
	
	/**
	* @Fields rows : 使用easyUI默认datagrid属性时的每页显示数据
	*/
	private int rows;
	
	/**
	* @Fields sort : 排序字段
	*/
	private String sort;
	
	/**
	* @Fields order : 排序方式
	*/
	private String order;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
