package com.chinasofti.mall.common.entity;

public class PyMainGoodsorderWithBLOBs extends PyMainGoodsorder {
    private String buyersMessage;

    private String senddesc;

    public String getBuyersMessage() {
        return buyersMessage;
    }

    public void setBuyersMessage(String buyersMessage) {
        this.buyersMessage = buyersMessage == null ? null : buyersMessage.trim();
    }

    public String getSenddesc() {
        return senddesc;
    }

    public void setSenddesc(String senddesc) {
        this.senddesc = senddesc == null ? null : senddesc.trim();
    }
}