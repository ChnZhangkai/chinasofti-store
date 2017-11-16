package com.chinasofti.mall.common.entity;

import java.util.HashSet;
import java.util.Set;

public class PtOperator {
    private String ids;

    private String description;

    private String names;
    
    private String operator;

    private String menuids;

    private String createtime;

    private String createby;

    private String updatetime;

    private String updateby;
    
    private Set<PtRole> roles = new HashSet<PtRole>();

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names == null ? null : names.trim();
    }

    public String getMenuids() {
        return menuids;
    }

    public void setMenuids(String menuids) {
        this.menuids = menuids == null ? null : menuids.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Set<PtRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<PtRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "PtOperator [ids=" + ids + ", description=" + description
				+ ", names=" + names + ", operator=" + operator + ", menuids="
				+ menuids + ", createtime=" + createtime + ", createby="
				+ createby + ", updatetime=" + updatetime + ", updateby="
				+ updateby + ", roles=" + roles + "]";
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ids == null) ? 0 : ids.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PtOperator other = (PtOperator) obj;
		if (ids == null) {
			if (other.ids != null)
				return false;
		} else if (!ids.equals(other.ids))
			return false;
		return true;
	}
    
    
}