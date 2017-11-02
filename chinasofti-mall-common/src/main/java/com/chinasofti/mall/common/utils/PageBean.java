package com.chinasofti.mall.common.utils;

public class PageBean {
	
		//总条数
		private int total;
		//每页显示数据
		private int pageSize;
		//当前页码
		private int pageNumber;
		
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
	
}
