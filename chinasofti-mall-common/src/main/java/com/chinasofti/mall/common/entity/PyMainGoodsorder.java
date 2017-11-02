package com.chinasofti.mall.common.entity;

import java.math.BigDecimal;

public class PyMainGoodsorder {
	
    private String ids;				

    private String bigorderId;		//大订单流水

    private String vendorIds;		//商户号

    private String userIds;			//用户ids

    private String contPostcode;	//邮编

    private String contAddress;		//地址

    private String contMobile;		//座机

    private String contPhone;		//手机

    private String contProvince;	//省份

    private String contCity;		//市

    private String contDistrict;	//区

    private String contStreet;		//街道

    private String deliveryTime;	//配送时间 格式如 9:00-18:00

    private String deliveryDate;	//配送日期 格式如20151022-20151022

    private String deliveryWay;		//配送方式 1 快递 2 自提

    private String orderTime;		//订单时间

    private String settleTime;		//清算时间

    private String isevaluate;		//0 未评价 1 已评价

    private BigDecimal discount;	//折扣

    private BigDecimal orderTotalAmt;	//订单总额

    private BigDecimal orderAmt;		//实付金额

    private BigDecimal settleAmt;		//清算金额

    private String settleStatues;		//清算状态,0:未清算,1:清算成功,2:清算失败,3:清算中,4:手续到中间户进行中,
    									//5:手续到中间户完成,6:手续到中间户失败,NN:无需清算

    private String payStatus;			//0 未支付 1 已支付  2 取消

    private String status;				//0 已删除  1 未发货 2 已发货 3 已收货 

    private String payway;				//支付方式 1 微信

    private String transactionid;		//流水号

    private String contName;			//联系人

    private String settleBatchNo;		//清算批次

    private BigDecimal wxFee;			//微信手续费

    private String settleStatusFee;		//手续续清算状态,0:未清算,1:清算成功,2:清算失败,3:清算中,
    									//4:手续到中间户进行中,5:手续到中间户完成,6:手续到中间户失败,NN:无需清算

    private String settleTimeFee;		//手续费清算时间

    private String settleBatchNoFee;	//手续费清算批次

    private String payTime;				//支付时间

    private String isTicket;			//是否使用优惠券

    private String expressCompanyId;	//快递公司编号

    private String expressName;			//快递公司名称

    private String expressId;			//快递单号

    private String sendouttime;			//发货时间

    private String updatetime;			//操作更新时间

    private String sLatitude;			//提交订单纬度

    private String sLongitude;			//提交订单经度

    private String pLatitude;			//支付订单纬度

    private String pLongitude;			//支付订单经度

    private BigDecimal freightOld;		//原运费(即下单时计算出的运费)

    private String contProvinceCode;	//省编码

    private String contCityCode;		//市编码

    private String contDistrictCode;	//区编码

    private BigDecimal freight;			//运费

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getBigorderId() {
        return bigorderId;
    }

    public void setBigorderId(String bigorderId) {
        this.bigorderId = bigorderId == null ? null : bigorderId.trim();
    }

    public String getVendorIds() {
        return vendorIds;
    }

    public void setVendorIds(String vendorIds) {
        this.vendorIds = vendorIds == null ? null : vendorIds.trim();
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

    public String getContPostcode() {
        return contPostcode;
    }

    public void setContPostcode(String contPostcode) {
        this.contPostcode = contPostcode == null ? null : contPostcode.trim();
    }

    public String getContAddress() {
        return contAddress;
    }

    public void setContAddress(String contAddress) {
        this.contAddress = contAddress == null ? null : contAddress.trim();
    }

    public String getContMobile() {
        return contMobile;
    }

    public void setContMobile(String contMobile) {
        this.contMobile = contMobile == null ? null : contMobile.trim();
    }

    public String getContPhone() {
        return contPhone;
    }

    public void setContPhone(String contPhone) {
        this.contPhone = contPhone == null ? null : contPhone.trim();
    }

    public String getContProvince() {
        return contProvince;
    }

    public void setContProvince(String contProvince) {
        this.contProvince = contProvince == null ? null : contProvince.trim();
    }

    public String getContCity() {
        return contCity;
    }

    public void setContCity(String contCity) {
        this.contCity = contCity == null ? null : contCity.trim();
    }

    public String getContDistrict() {
        return contDistrict;
    }

    public void setContDistrict(String contDistrict) {
        this.contDistrict = contDistrict == null ? null : contDistrict.trim();
    }

    public String getContStreet() {
        return contStreet;
    }

    public void setContStreet(String contStreet) {
        this.contStreet = contStreet == null ? null : contStreet.trim();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate == null ? null : deliveryDate.trim();
    }

    public String getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay == null ? null : deliveryWay.trim();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public String getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(String settleTime) {
        this.settleTime = settleTime == null ? null : settleTime.trim();
    }

    public String getIsevaluate() {
        return isevaluate;
    }

    public void setIsevaluate(String isevaluate) {
        this.isevaluate = isevaluate == null ? null : isevaluate.trim();
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

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public BigDecimal getSettleAmt() {
        return settleAmt;
    }

    public void setSettleAmt(BigDecimal settleAmt) {
        this.settleAmt = settleAmt;
    }

    public String getSettleStatues() {
        return settleStatues;
    }

    public void setSettleStatues(String settleStatues) {
        this.settleStatues = settleStatues == null ? null : settleStatues.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
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

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName == null ? null : contName.trim();
    }

    public String getSettleBatchNo() {
        return settleBatchNo;
    }

    public void setSettleBatchNo(String settleBatchNo) {
        this.settleBatchNo = settleBatchNo == null ? null : settleBatchNo.trim();
    }

    public BigDecimal getWxFee() {
        return wxFee;
    }

    public void setWxFee(BigDecimal wxFee) {
        this.wxFee = wxFee;
    }

    public String getSettleStatusFee() {
        return settleStatusFee;
    }

    public void setSettleStatusFee(String settleStatusFee) {
        this.settleStatusFee = settleStatusFee == null ? null : settleStatusFee.trim();
    }

    public String getSettleTimeFee() {
        return settleTimeFee;
    }

    public void setSettleTimeFee(String settleTimeFee) {
        this.settleTimeFee = settleTimeFee == null ? null : settleTimeFee.trim();
    }

    public String getSettleBatchNoFee() {
        return settleBatchNoFee;
    }

    public void setSettleBatchNoFee(String settleBatchNoFee) {
        this.settleBatchNoFee = settleBatchNoFee == null ? null : settleBatchNoFee.trim();
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

    public String getExpressCompanyId() {
        return expressCompanyId;
    }

    public void setExpressCompanyId(String expressCompanyId) {
        this.expressCompanyId = expressCompanyId == null ? null : expressCompanyId.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }

    public String getSendouttime() {
        return sendouttime;
    }

    public void setSendouttime(String sendouttime) {
        this.sendouttime = sendouttime == null ? null : sendouttime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getsLatitude() {
        return sLatitude;
    }

    public void setsLatitude(String sLatitude) {
        this.sLatitude = sLatitude == null ? null : sLatitude.trim();
    }

    public String getsLongitude() {
        return sLongitude;
    }

    public void setsLongitude(String sLongitude) {
        this.sLongitude = sLongitude == null ? null : sLongitude.trim();
    }

    public String getpLatitude() {
        return pLatitude;
    }

    public void setpLatitude(String pLatitude) {
        this.pLatitude = pLatitude == null ? null : pLatitude.trim();
    }

    public String getpLongitude() {
        return pLongitude;
    }

    public void setpLongitude(String pLongitude) {
        this.pLongitude = pLongitude == null ? null : pLongitude.trim();
    }

    public BigDecimal getFreightOld() {
        return freightOld;
    }

    public void setFreightOld(BigDecimal freightOld) {
        this.freightOld = freightOld;
    }

    public String getContProvinceCode() {
        return contProvinceCode;
    }

    public void setContProvinceCode(String contProvinceCode) {
        this.contProvinceCode = contProvinceCode == null ? null : contProvinceCode.trim();
    }

    public String getContCityCode() {
        return contCityCode;
    }

    public void setContCityCode(String contCityCode) {
        this.contCityCode = contCityCode == null ? null : contCityCode.trim();
    }

    public String getContDistrictCode() {
        return contDistrictCode;
    }

    public void setContDistrictCode(String contDistrictCode) {
        this.contDistrictCode = contDistrictCode == null ? null : contDistrictCode.trim();
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }
}