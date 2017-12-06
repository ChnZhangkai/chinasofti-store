package com.chinasofti.mall.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商城后台管理用户权限菜单树
 * 
 * @author 黄佳喜
 */
public class Tree implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	
	private String text;
	private String state;
	private String iconCls;
	private boolean checked;
	private List<Tree> children;
	private String states;//启用或禁用的状态
	
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
