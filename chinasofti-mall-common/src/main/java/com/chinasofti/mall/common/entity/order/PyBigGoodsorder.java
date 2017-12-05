package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
import java.util.List;

public class PyBigGoodsorder {
    private String ids;
    /** *  订单流水号 */
    private String transactionid;
    
    private String orderDate;
    /** *  订单的真实收税金额 */
    private BigDecimal orderRealAmt;
    /** *  订单折扣 */
    private BigDecimal discount;
    /** *  订单的全部收税金额 */
    private BigDecimal orderTotalAmt;
    /** *  商品的全部收税金额 */
    private BigDecimal goodsTotalAmt;
    /** *  订单的用户ids */
    private String userIds;
    /** *  订单的状态  0 无效 1 有效*/
    private String status;
    /** *  订单的支付方式 */
    private String payway;
    /** *  订单的支付状态 0 未支付 1 已支付  2 已取消*/
    private String payStatus;
    /** *  订单的检查状态 */
    private String checkingStatus;
    /** *  订单的确认时间 */
    private String checkDate;
    /** *  订单处理的批次 */
    private String checkBatchNo;
    /** *  订单微信手续费 */
    private BigDecimal wxFee;
    /** *  订单付款时间 */
    private String payTime;
    /** *  订单是否开发票 */
    private String isTicket;
    /** *  订单的发票类型 */
    private String invoiceType;
    /** *  订单的发票抬头 */
    private String invoiceTitle;
    /** *  订单的发票地址 */
    private String invoiceAddress;
    
    private List<PyChildGoodsorder> pyChildGoodsorders;

	public List<PyChildGoodsorder> getPyChildGoodsorders() {
		return pyChildGoodsorders;
	}

	public void setPyChildGoodsorders(List<PyChildGoodsorder> pyChildGoodsorders) {
		this.pyChildGoodsorders = pyChildGoodsorders;
	}

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
    
    private BigDecimal orderTotalNum;

	public BigDecimal getOrderTotalNum() {
		return orderTotalNum;
	}

	public void setOrderTotalNum(BigDecimal orderTotalNum) {
		this.orderTotalNum = orderTotalNum;
	}
    
}