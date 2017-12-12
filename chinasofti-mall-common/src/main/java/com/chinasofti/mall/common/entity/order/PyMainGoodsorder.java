package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
import java.util.List;

import com.chinasofti.mall.common.utils.PageBean;
import com.chinasofti.mall.common.utils.StringDateUtil;

public class PyMainGoodsorder extends PageBean{
	
    @Override
	public String toString() {
		return "PyMainGoodsorder [ids=" + ids + ", bigorderId=" + bigorderId + ", userIds=" + userIds + ", payStatus="
				+ payStatus + ", status=" + status + ", transactionid=" + transactionid + "]";
	}
	/**
    * @Fields ids : 主键
    */
    private String ids;

    /**
    * @Fields bigorderId : 大订单号
    */
    private String bigorderId;

    /**
    * @Fields vendorIds : 商户号
    */
    private String vendorIds;

    /**
    * @Fields userIds : 用户id
    */
    private String userIds;

    /**
    * @Fields contPostcode : 邮编
    */
    private String contPostcode;

    /**
    * @Fields contAddress : 详细地址
    */
    private String contAddress;

    /**
    * @Fields contMobile : 座机
    */
    private String contMobile;

    /**
    * @Fields contPhone : 手机
    */
    private String contPhone;

    /**
    * @Fields contProvince : 身份
    */
    private String contProvince;

    /**
    * @Fields contCity : 市
    */
    private String contCity;

    /**
    * @Fields contDistrict : 区
    */
    private String contDistrict;

    /**
    * @Fields contStreet : 街道
    */
    private String contStreet;

    /**
    * @Fields deliveryTime : 配送时间 格式如 9:00-18:00
    */
    private String deliveryTime;

    /**
    * @Fields deliveryDate : 配送日期 格式如20151022-20151022
    */
    private String deliveryDate;

    /**
    * @Fields deliveryWay : 配送方式 1 快递 2 自提
    */
    private String deliveryWay;

    /**
    * @Fields buyersMessage : 顾客留言
    */
    private String buyersMessage;

    /**
    * @Fields orderTime : 订单时间
    */
    private String orderTime;

    /**
    * @Fields settleTime : 清算时间
    */
    private String settleTime;

    /**
    * @Fields isevaluate : 评价状态：0 未评价 1 已评价
    */
    private String isevaluate;

    /**
    * @Fields discount : 折扣
    */
    private BigDecimal discount;

    /**
    * @Fields orderTotalAmt : 订单总额
    */
    private BigDecimal orderTotalAmt;

    /**
    * @Fields orderAmt : 实付金额
    */
    private BigDecimal orderAmt;

    /**
    * @Fields settleAmt : 清算金额
    */
    private BigDecimal settleAmt;

    /**
    * @Fields settleStatues : 清算状态,0:未清算,1:清算成功,2:清算失败,3:清算中,4:手续到中间户进行中,
    * 								5:手续到中间户完成,6:手续到中间户失败,NN:无需清算
    */
    private String settleStatues;

    /**
    * @Fields payStatus : 支付状态：0 未支付 1 已支付  2 取消
    */
    private String payStatus;

    /**
    * @Fields status : 订单状态: 0 待付款  1 待发货 2 待收货 3 交易成功  4 交易关闭（已删除） 5 交易关闭（已取消） 6 交易关闭（退款成功）
    */
    private String status;

    /**
    * @Fields payway : 支付渠道 : 1 微信  2 支付宝 3 银联
    */
    private String payway;

    /**
    * @Fields transactionid : 流水号: 主订单编号
    */
    private String transactionid;

    /**
    * @Fields contName : 联系人
    */
    private String contName;

    /**
    * @Fields settleBatchNo : 清算批次
    */
    private String settleBatchNo;

    /**
    * @Fields wxFee : 微信手续费
    */
    private BigDecimal wxFee;

    /**
    * @Fields settleStatusFee : 手续续清算状态,0:未清算,1:清算成功,2:清算失败,3:清算中,4:手续到中间户进行中,
    * 										5:手续到中间户完成,6:手续到中间户失败,NN:无需清算
    */
    private String settleStatusFee;

    /**
    * @Fields settleTimeFee : 手续费清算时间
    */
    private String settleTimeFee;

    /**
    * @Fields settleBatchNoFee : 手续费清算批次
    */
    private String settleBatchNoFee;

    /**
    * @Fields payTime : 支付时间
    */
    private String payTime;

    /**
    * @Fields isTicket : 是否使用优惠券
    */
    private String isTicket;

    /**
    * @Fields expressCompanyId : 快递公司编号
    */
    private String expressCompanyId;

    /**
    * @Fields expressName : 快递公司名称
    */
    private String expressName;

    /**
    * @Fields expressId : 快递单号
    */
    private String expressId;

    /**
    * @Fields sendouttime : 发货时间
    */
    private String sendouttime;

    /**
    * @Fields updatetime : 操作更新时间
    */
    private String updatetime;

    /**
    * @Fields sLatitude : 提交订单纬度
    */
    private String sLatitude;

    /**
    * @Fields sLongitude : 提交订单经度
    */
    private String sLongitude;

    /**
    * @Fields pLatitude : 支付订单纬度
    */
    private String pLatitude;

    /**
    * @Fields pLongitude : 支付订单经度
    */
    private String pLongitude;

    /**
    * @Fields senddesc : 发货备注
    */
    private String senddesc;

    /**
    * @Fields freightOld : 原运费(即下单时计算出的运费)
    */
    private BigDecimal freightOld;

    /**
    * @Fields contProvinceCode : 省编码
    */
    private String contProvinceCode;

    /**
    * @Fields contCityCode : 市编码
    */
    private String contCityCode;

    /**
    * @Fields contDistrictCode : 区编码
    */
    private String contDistrictCode;

    /**
    * @Fields freight : 运费
    */
    private BigDecimal freight;
    
    
    private String vendorSnm;


	public String getVendorSnm() {
		return vendorSnm;
	}

	public void setVendorSnm(String vendorSnm) {
		this.vendorSnm = vendorSnm;
	}

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

    public String getBuyersMessage() {
        return buyersMessage;
    }

    public void setBuyersMessage(String buyersMessage) {
        this.buyersMessage = buyersMessage == null ? null : buyersMessage.trim();
    }

    public String getOrderTime() {
    	if(orderTime != null){
    		return StringDateUtil.convertToPageFormat(orderTime);
    	} else {
    		return orderTime;
    	}
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public String getSettleTime() {
    	if(settleTime != null){
    		return StringDateUtil.convertToPageFormat(settleTime);
    	} else {
    		return settleTime;
    	}
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
    	if(settleTimeFee != null){
    		return StringDateUtil.convertToPageFormat(settleTimeFee);
    	} else {
    		return settleTimeFee;
    	}
        
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
    	if(sendouttime != null && !sendouttime.equals("")) {
    		return StringDateUtil.convertToPageFormat(sendouttime);
    	}else {
    		return sendouttime;
    	}
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

    public String getSenddesc() {
        return senddesc;
    }

    public void setSenddesc(String senddesc) {
        this.senddesc = senddesc == null ? null : senddesc.trim();
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
    private List<PyChildGoodsorder> pyChildGoodsorders;

	public List<PyChildGoodsorder> getPyChildGoodsorders() {
		return pyChildGoodsorders;
	}

	public void setPyChildGoodsorders(List<PyChildGoodsorder> pyChildGoodsorders) {
		this.pyChildGoodsorders = pyChildGoodsorders;
	}
    
}