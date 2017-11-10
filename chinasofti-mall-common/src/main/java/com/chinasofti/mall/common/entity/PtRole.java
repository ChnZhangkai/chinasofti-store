package com.chinasofti.mall.common.entity;

import java.util.HashSet;
import java.util.Set;

public class PtRole {
    private String ids;

    private String numbers;

    private String names;

    private String updateby;

    private String createtime;

    private String updatetime;

    private String createby;

    private String description;
    
    private Set<PtUser> users = new HashSet<PtUser>();
    
    private Set<PtOperator> ptoperators = new HashSet<PtOperator>();

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers == null ? null : numbers.trim();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names == null ? null : names.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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