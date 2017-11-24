package com.chinasofti.mall.common.entity;


import java.util.HashSet;
import java.util.Set;

import com.chinasofti.mall.common.utils.PageBean;

public class PtRole extends PageBean{
    private String ids;

    private String numbers;

    private String names;

    private String updateby;

    private String createtime;

    private String updatetime;

    private String createby;

    private String description;//DESCRIPTION

	public String getIds() {
		return ids;
	}
    
    private Set<PtUser> users = new HashSet<PtUser>();
    
    private Set<PtOperator> ptoperators = new HashSet<PtOperator>();

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PtUser> getUsers() {
		return users;
	}

	public void setUsers(Set<PtUser> users) {
		this.users = users;
	}

	public Set<PtOperator> getPtoperators() {
		return ptoperators;
	}

	public void setPtoperators(Set<PtOperator> ptoperators) {
		this.ptoperators = ptoperators;
	}

	@Override
	public String toString() {
		return "PtRole [ids=" + ids + ", numbers=" + numbers + ", names="
				+ names + ", updateby=" + updateby + ", createtime="
				+ createtime + ", updatetime=" + updatetime + ", createby="
				+ createby + ", description=" + description + ", users="
				+ users + ", ptoperators=" + ptoperators + "]";
	}

    
}