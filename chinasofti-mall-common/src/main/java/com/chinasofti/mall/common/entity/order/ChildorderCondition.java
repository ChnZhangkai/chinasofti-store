package com.chinasofti.mall.common.entity.order;

import com.chinasofti.mall.common.utils.PageBean;

public class ChildorderCondition extends PageBean{
	
	private String transactionid;
	
	private String mainorderIds;
	
	private String type;
	
	private String orderType;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid == null ? null : transactionid.trim();
	}

	public String getMainorderIds() {
		return mainorderIds;
	}

	public void setMainorderIds(String mainorderIds) {
		this.mainorderIds = mainorderIds == null ? null : mainorderIds.trim();
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType == null ? null : orderType.trim();
	}

}
