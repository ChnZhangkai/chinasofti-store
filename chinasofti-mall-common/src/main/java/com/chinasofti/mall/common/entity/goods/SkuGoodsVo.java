package com.chinasofti.mall.common.entity.goods;
/**
 * 
* @ClassName: SkuGoodsVo
* @Description: sku商品规格vo
* @author km
* @date 2017年12月20日 上午10:30:37 
*
 */
public class SkuGoodsVo {
	
	private String skuIds;
	
	private String skuCode;//sku编码

	private Double skuSalePrice;//售价

	private Double skuMarketPrice;//市场价格

	private Integer skuStock;//库存
	
	private String attrName;//属性名
	
	private String attrValue;//属性值
	
	private Integer skuSales;//销量
	
	private String filePath;//图片路径
	
	

	public String getSkuIds() {
		return skuIds;
	}

	public void setSkuIds(String skuIds) {
		this.skuIds = skuIds;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getSkuSales() {
		return skuSales;
	}

	public void setSkuSales(Integer skuSales) {
		this.skuSales = skuSales;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	
	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public Double getSkuSalePrice() {
		return skuSalePrice;
	}

	public void setSkuSalePrice(Double skuSalePrice) {
		this.skuSalePrice = skuSalePrice;
	}

	public Double getSkuMarketPrice() {
		return skuMarketPrice;
	}

	public void setSkuMarketPrice(Double skuMarketPrice) {
		this.skuMarketPrice = skuMarketPrice;
	}


	public Integer getSkuStock() {
		return skuStock;
	}

	public void setSkuStock(Integer skuStock) {
		this.skuStock = skuStock;
	}
	
	
}
