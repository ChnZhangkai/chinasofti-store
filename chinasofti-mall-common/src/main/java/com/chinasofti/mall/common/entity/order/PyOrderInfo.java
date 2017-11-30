package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
import java.util.List;

//立即购买、购物车订单
public class PyOrderInfo {
	/** *  大订单流水    防止订单重复提交*/
	private String OrderNo;
	/** *  用户ID */
	private String userId;
	/** *  地址ID */
	private String addressId;
	/** *  订单金额 */
    private BigDecimal orderRealAmt;
    /** *  购物车*/
    private List<PyShoppingCartInfo> shopCart;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public BigDecimal getOrderRealAmt() {
		return orderRealAmt;
	}
	public void setOrderRealAmt(BigDecimal orderRealAmt) {
		this.orderRealAmt = orderRealAmt;
	}
	public List<PyShoppingCartInfo> getShopCart() {
		return shopCart;
	}
	public void setShopCart(List<PyShoppingCartInfo> shopCart) {
		this.shopCart = shopCart;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
    
	
}
