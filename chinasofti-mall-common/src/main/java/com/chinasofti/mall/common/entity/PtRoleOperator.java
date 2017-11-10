package com.chinasofti.mall.common.entity;

/**
 * 多表关联的中间表
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月10日 下午5:34:41
 * @parma <T>
 */
public class PtRoleOperator {
	private String ids;
	private String roleids;
	private String operatorids;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getRoleids() {
		return roleids;
	}
	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	public String getOperatorids() {
		return operatorids;
	}
	public void setOperatorids(String operatorids) {
		this.operatorids = operatorids;
	}
}
