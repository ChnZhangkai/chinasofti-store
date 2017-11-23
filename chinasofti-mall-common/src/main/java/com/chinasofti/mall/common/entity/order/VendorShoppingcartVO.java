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
	    
	    private BigDecimal price;

	    private BigDecimal disPrice;
	    
	    private BigDecimal orgPrice;
	    
	    private String standard;


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
}
