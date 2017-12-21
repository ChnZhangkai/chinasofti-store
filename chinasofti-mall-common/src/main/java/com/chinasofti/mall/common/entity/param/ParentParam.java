package com.chinasofti.mall.common.entity.param;

import com.chinasofti.mall.common.utils.PageBean;

public class ParentParam extends PageBean{
    private Integer id;

    private String text;

    private String description;

    private String cearttime;

    private String status;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCearttime() {
        return cearttime;
    }

    public void setCearttime(String cearttime) {
        this.cearttime = cearttime == null ? null : cearttime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}