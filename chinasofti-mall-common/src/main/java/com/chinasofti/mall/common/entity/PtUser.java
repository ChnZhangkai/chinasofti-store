package com.chinasofti.mall.common.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.chinasofti.mall.common.utils.PageBean;

public class PtUser extends PageBean{
    private String ids;

    private Long version;

    private Long errorcount;

    private Long orderids;

    private String status;

    private Date stopdate;

    private String username;
    
    private String password;

    private String departmentids;

    private String userinfoids;

    private String departmentnames;

    private String unionid;
    
    private Set<PtRole> roles = new HashSet<PtRole>();

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getErrorcount() {
        return errorcount;
    }

    public void setErrorcount(Long errorcount) {
        this.errorcount = errorcount;
    }

    public Long getOrderids() {
        return orderids;
    }

    public void setOrderids(Long orderids) {
        this.orderids = orderids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getStopdate() {
        return stopdate;
    }

    public void setStopdate(Date stopdate) {
        this.stopdate = stopdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDepartmentids() {
        return departmentids;
    }

    public void setDepartmentids(String departmentids) {
        this.departmentids = departmentids == null ? null : departmentids.trim();
    }

    public String getUserinfoids() {
        return userinfoids;
    }

    public void setUserinfoids(String userinfoids) {
        this.userinfoids = userinfoids == null ? null : userinfoids.trim();
    }

    public String getDepartmentnames() {
        return departmentnames;
    }

    public void setDepartmentnames(String departmentnames) {
        this.departmentnames = departmentnames == null ? null : departmentnames.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

	public Set<PtRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<PtRole> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PtUser [ids=" + ids + ", version=" + version + ", errorcount="
				+ errorcount + ", orderids=" + orderids + ", status=" + status
				+ ", stopdate=" + stopdate + ", username=" + username
				+ ", password=" + password + ", departmentids=" + departmentids
				+ ", userinfoids=" + userinfoids + ", departmentnames="
				+ departmentnames + ", unionid=" + unionid + ", roles=" + roles
				+ "]";
	}
    
}