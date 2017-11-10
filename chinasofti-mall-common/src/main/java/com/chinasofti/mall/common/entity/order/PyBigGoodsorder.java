package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;

public class PyBigGoodsorder {
    private String ids;

    private String transactionid;

    private String orderDate;

    private BigDecimal orderRealAmt;

    private BigDecimal discount;

    private BigDecimal orderTotalAmt;

    private BigDecimal goodsTotalAmt;

    private String userIds;

    private String status;

    private String payway;

    private String payStatus;

    private String checkingStatus;

    private String checkDate;

    private String checkBatchNo;

    private BigDecimal wxFee;

    private String payTime;

    private String isTicket;

    private String invoiceType;

    private String invoiceTitle;

    private String invoiceAddress;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    public BigDecimal getOrderRealAmt() {
        return orderRealAmt;
    }

    public void setOrderRealAmt(BigDecimal orderRealAmt) {
        this.orderRealAmt = orderRealAmt;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getOrderTotalAmt() {
        return orderTotalAmt;
    }

    public void setOrderTotalAmt(BigDecimal orderTotalAmt) {
        this.orderTotalAmt = orderTotalAmt;
    }

    public BigDecimal getGoodsTotalAmt() {
        return goodsTotalAmt;
    }

    public void setGoodsTotalAmt(BigDecimal goodsTotalAmt) {
        this.goodsTotalAmt = goodsTotalAmt;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway == null ? null : payway.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getCheckingStatus() {
        return checkingStatus;
    }

    public void setCheckingStatus(String checkingStatus) {
        this.checkingStatus = checkingStatus == null ? null : checkingStatus.trim();
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate == null ? null : checkDate.trim();
    }

    public String getCheckBatchNo() {
        return checkBatchNo;
    }

    public void setCheckBatchNo(String checkBatchNo) {
        this.checkBatchNo = checkBatchNo == null ? null : checkBatchNo.trim();
    }

    public BigDecimal getWxFee() {
        return wxFee;
    }

    public void setWxFee(BigDecimal wxFee) {
        this.wxFee = wxFee;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    public String getIsTicket() {
        return isTicket;
    }

    public void setIsTicket(String isTicket) {
        this.isTicket = isTicket == null ? null : isTicket.trim();
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress == null ? null : invoiceAddress.trim();
    }
}