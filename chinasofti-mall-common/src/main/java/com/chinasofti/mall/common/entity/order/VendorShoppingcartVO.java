package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
/**
 * 购物车列表
 * 返回Vo
 * @author gezhenlin
 *
 */

public class VendorShoppingcartVO extends PyShoppingCart{


	    private String vendorFnm;

	    private String vendorSnm;
	    
	    private String goodsName;
	    
	    private BigDecimal price;

	    private BigDecimal disPrice;
	    
	    private BigDecimal orgPrice;
	    
	    private String standard;
	    
	    private BigDecimal limitOrderNum;
	    
	    private BigDecimal limitUserNum;
	    
	    private BigDecimal collNum;
	    
	    private BigDecimal storeNum;
	    
	    private BigDecimal totalTrade;
	    
	    private String status;
	    
	    private String filepath;


		public String getVendorFnm() {
			return vendorFnm;
		}

		public void setVendorFnm(String vendorFnm) {
			this.vendorFnm = vendorFnm;
		}

		public String getVendorSnm() {
			return vendorSnm;
		}

		public void setVendorSnm(String vendorSnm) {
			this.vendorSnm = vendorSnm;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public BigDecimal getDisPrice() {
			return disPrice;
		}

		public void setDisPrice(BigDecimal disPrice) {
			this.disPrice = disPrice;
		}

		public String getStandard() {
			return standard;
		}

		public void setStandard(String standard) {
			this.standard = standard;
		}

		public BigDecimal getOrgPrice() {
			return orgPrice;
		}

		public void setOrgPrice(BigDecimal orgPrice) {
			this.orgPrice = orgPrice;
		}

		public String getGoodsName() {
			return goodsName;
		}

		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}

		public String getFilepath() {
			return filepath;
		}

		public void setFilepath(String filepath) {
			this.filepath = filepath;
		}

		public BigDecimal getLimitOrderNum() {
			return limitOrderNum;
		}

		public void setLimitOrderNum(BigDecimal limitOrderNum) {
			this.limitOrderNum = limitOrderNum;
		}

		public BigDecimal getLimitUserNum() {
			return limitUserNum;
		}

		public void setLimitUserNum(BigDecimal limitUserNum) {
			this.limitUserNum = limitUserNum;
		}

		public BigDecimal getCollNum() {
			return collNum;
		}

		public void setCollNum(BigDecimal collNum) {
			this.collNum = collNum;
		}

		public BigDecimal getStoreNum() {
			return storeNum;
		}

		public void setStoreNum(BigDecimal storeNum) {
			this.storeNum = storeNum;
		}

		public BigDecimal getTotalTrade() {
			return totalTrade;
		}

		public void setTotalTrade(BigDecimal totalTrade) {
			this.totalTrade = totalTrade;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
}
