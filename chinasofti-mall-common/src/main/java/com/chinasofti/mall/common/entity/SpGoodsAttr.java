package com.chinasofti.mall.common.entity;

public class SpGoodsAttr {
    private String ids;

    private String name;

    private String commom;

    private String classValue;

    private String needpic;

    private String states;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private Integer orderValue;

    private String deleteStatus;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCommom() {
        return commom;
    }

    public void setCommom(String commom) {
        this.commom = commom == null ? null : commom.trim();
    }

    public String getClassValue() {
        return classValue;
    }

    public void setClassValue(String classValue) {
        this.classValue = classValue == null ? null : classValue.trim();
    }

    public String getNeedpic() {
        return needpic;
    }

    public void setNeedpic(String needpic) {
        this.needpic = needpic == null ? null : needpic.trim();
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states == null ? null : states.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}