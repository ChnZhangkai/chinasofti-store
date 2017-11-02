package com.chinasofti.mall.common.entity;

import java.math.BigDecimal;

public class CmsAdContents {
    private String ids;

    private String states;

    private String createBy;

    private String createTime;

    private String updateBy;

    private String updateTime;

    private String beginTime;

    private String endTime;

    private String positionId;

    private BigDecimal descs;

    private String isOuturl;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states == null ? null : states.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public BigDecimal getDescs() {
        return descs;
    }

    public void setDescs(BigDecimal descs) {
        this.descs = descs;
    }

    public String getIsOuturl() {
        return isOuturl;
    }

    public void setIsOuturl(String isOuturl) {
        this.isOuturl = isOuturl == null ? null : isOuturl.trim();
    }
}