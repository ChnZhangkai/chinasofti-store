package com.chinasofti.mall.common.entity.goods;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	
	private Integer skuSales;//销量
	
	private String filePath;//图片路径
	
	private String skuOptionIds;
	
	private List<AttrVo> attrList = new ArrayList<>();//属性集合
	
	
	
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

	public List<AttrVo> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<AttrVo> attrList) {
		this.attrList = attrList;
	}

	public String getSkuOptionIds() {
		return skuOptionIds;
	}

	public void setSkuOptionIds(String skuOptionIds) {
		this.skuOptionIds = skuOptionIds;
	}

	@Override
	public String toString() {
		return "SkuGoodsVo [skuIds=" + skuIds + ", skuCode=" + skuCode + ", skuSalePrice=" + skuSalePrice
				+ ", skuMarketPrice=" + skuMarketPrice + ", skuStock=" + skuStock + ", skuSales=" + skuSales
				+ ", filePath=" + filePath + ", skuOptionIds=" + skuOptionIds + ", attrList=" + attrList + "]";
	}
	
	
	
	
	
}
