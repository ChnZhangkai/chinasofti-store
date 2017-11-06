package com.chinasofti.mall.common.entity;

import java.math.BigDecimal;

public class PyPayorder {
    private String ids;

    private String orderids;

    private BigDecimal payprice;

    private String paytime;

    private String userid;

    private String paystatus;

    private String paychannel;

    private String payfinishtime;

    private String channelorderid;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getOrderids() {
        return orderids;
    }

    public void setOrderids(String orderids) {
        this.orderids = orderids == null ? null : orderids.trim();
    }

    public BigDecimal getPayprice() {
        return payprice;
    }

    public void setPayprice(BigDecimal payprice) {
        this.payprice = payprice;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime == null ? null : paytime.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getPaychannel() {
        return paychannel;
    }

    public void setPaychannel(String paychannel) {
        this.paychannel = paychannel == null ? null : paychannel.trim();
    }

    public String getPayfinishtime() {
        return payfinishtime;
    }

    public void setPayfinishtime(String payfinishtime) {
        this.payfinishtime = payfinishtime == null ? null : payfinishtime.trim();
    }

    public String getChannelorderid() {
        return channelorderid;
    }

    public void setChannelorderid(String channelorderid) {
        this.channelorderid = channelorderid == null ? null : channelorderid.trim();
    }
}