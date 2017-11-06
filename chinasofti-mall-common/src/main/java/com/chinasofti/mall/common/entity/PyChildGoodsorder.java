package com.chinasofti.mall.common.entity;

import java.math.BigDecimal;

public class PyChildGoodsorder {
    private String ids;

    private String mainorderIds;

    private String goodsids;

    private String custIds;

    private String orderStatus;

    private BigDecimal goodsNum;

    private BigDecimal goodsPrice;

    private BigDecimal discount;

    private BigDecimal orderRealAmt;

    private String isevaluate;

    private String orderRevoke;

    private String remark1;

    private String remark2;

    private String remark3;

    private String transactionid;

    private BigDecimal orderAmt;

    private String orderDate;

    private String venderRemark;

    private String orderType;

    private BigDecimal orderRealAmtOld;

    private BigDecimal freight;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getMainorderIds() {
        return mainorderIds;
    }

    public void setMainorderIds(String mainorderIds) {
        this.mainorderIds = mainorderIds == null ? null : mainorderIds.trim();
    }

    public String getGoodsids() {
        return goodsids;
    }

    public void setGoodsids(String goodsids) {
        this.goodsids = goodsids == null ? null : goodsids.trim();
    }

    public String getCustIds() {
        return custIds;
    }

    public void setCustIds(String custIds) {
        this.custIds = custIds == null ? null : custIds.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public BigDecimal getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(BigDecimal goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getOrderRealAmt() {
        return orderRealAmt;
    }

    public void setOrderRealAmt(BigDecimal orderRealAmt) {
        this.orderRealAmt = orderRealAmt;
    }

    public String getIsevaluate() {
        return isevaluate;
    }

    public void setIsevaluate(String isevaluate) {
        this.isevaluate = isevaluate == null ? null : isevaluate.trim();
    }

    public String getOrderRevoke() {
        return orderRevoke;
    }

    public void setOrderRevoke(String orderRevoke) {
        this.orderRevoke = orderRevoke == null ? null : orderRevoke.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    public String getVenderRemark() {
        return venderRemark;
    }

    public void setVenderRemark(String venderRemark) {
        this.venderRemark = venderRemark == null ? null : venderRemark.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public BigDecimal getOrderRealAmtOld() {
        return orderRealAmtOld;
    }

    public void setOrderRealAmtOld(BigDecimal orderRealAmtOld) {
        this.orderRealAmtOld = orderRealAmtOld;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }
}