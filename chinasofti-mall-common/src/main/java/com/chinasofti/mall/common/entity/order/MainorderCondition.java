package com.chinasofti.mall.common.entity.order;

import com.chinasofti.mall.common.utils.PageBean;

public class MainorderCondition extends PageBean {
	
	private String transactionid;
	
	private String bigorderId;
	
	private String payStatus;
	
	private String minPayTime;
	
	private String maxPayTime;
	
	private String contName;
	
	private String payway;
	
	private String orderStatus;
	
	private String settleTimeFee;
	
	private String vendorIds;

	public String getVendorIds() {
		return vendorIds;
	}

	public void setVendorIds(String vendorIds) {
		this.vendorIds = vendorIds;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getBigorderId() {
		return bigorderId;
	}

	public void setBigorderId(String bigorderId) {
		this.bigorderId = bigorderId;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getMinPayTime() {
		return minPayTime;
	}

	public void setMinPayTime(String minPayTime) {
		this.minPayTime = minPayTime;
	}

	public String getMaxPayTime() {
		return maxPayTime;
	}

	public void setMaxPayTime(String maxPayTime) {
		this.maxPayTime = maxPayTime;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSettleTimeFee() {
		return settleTimeFee;
	}

	public void setSettleTimeFee(String settleTimeFee) {
		this.settleTimeFee = settleTimeFee;
	}

}
