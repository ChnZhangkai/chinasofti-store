package com.chinasofti.mall.common.entity;

import java.util.HashSet;
import java.util.Set;

import com.chinasofti.mall.common.utils.PageBean;

public class PtUser extends PageBean{
    private String ids;

    private String version;

    private String errorcount;

    private String orderids;

    private String password;

    private String status;

    private String stopdate;

    private String username;

    private String departmentids;

    private String userinfoids;

    private String stationids;

    private String deptids;

    private String userids;

    private String departmentnames;

    private String stationnames;

    private String deptnames;

    private String usernames;

    private String groupnames;

    private String ismerchantuser;

    private String createtime;

    private String logincount;

    private String groupids;
    
    private Set<PtRole> roles = new HashSet<PtRole>();

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getErrorcount() {
		return errorcount;
	}

	public void setErrorcount(String errorcount) {
		this.errorcount = errorcount;
	}

	public String getOrderids() {
		return orderids;
	}

	public void setOrderids(String orderids) {
		this.orderids = orderids;
	}

	public void setLogincount(String logincount) {
		this.logincount = logincount;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStopdate() {
        return stopdate;
    }

    public void setStopdate(String stopdate) {
        this.stopdate = stopdate == null ? null : stopdate.trim();
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

    public String getStationids() {
        return stationids;
    }

    public void setStationids(String stationids) {
        this.stationids = stationids == null ? null : stationids.trim();
    }

    public String getDeptids() {
        return deptids;
    }

    public void setDeptids(String deptids) {
        this.deptids = deptids == null ? null : deptids.trim();
    }

    public String getUserids() {
        return userids;
    }

    public void setUserids(String userids) {
        this.userids = userids == null ? null : userids.trim();
    }

    public String getDepartmentnames() {
        return departmentnames;
    }

    public void setDepartmentnames(String departmentnames) {
        this.departmentnames = departmentnames == null ? null : departmentnames.trim();
    }

    public String getStationnames() {
        return stationnames;
    }

    public void setStationnames(String stationnames) {
        this.stationnames = stationnames == null ? null : stationnames.trim();
    }

    public String getDeptnames() {
        return deptnames;
    }

    public void setDeptnames(String deptnames) {
        this.deptnames = deptnames == null ? null : deptnames.trim();
    }

    public String getUsernames() {
        return usernames;
    }

    public void setUsernames(String usernames) {
        this.usernames = usernames == null ? null : usernames.trim();
    }

    public String getGroupnames() {
        return groupnames;
    }

    public void setGroupnames(String groupnames) {
        this.groupnames = groupnames == null ? null : groupnames.trim();
    }

    public String getIsmerchantuser() {
        return ismerchantuser;
    }

    public void setIsmerchantuser(String ismerchantuser) {
        this.ismerchantuser = ismerchantuser == null ? null : ismerchantuser.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
    
    public String getLogincount() {
		return logincount;
	}

	public String getGroupids() {
        return groupids;
    }

    public void setGroupids(String groupids) {
        this.groupids = groupids == null ? null : groupids.trim();
    }

	public Set<PtRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<PtRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "PtUser [ids=" + ids + ", version=" + version + ", errorcount=" + errorcount + ", orderids=" + orderids
				+ ", password=" + password + ", status=" + status + ", stopdate=" + stopdate + ", username=" + username
				+ ", departmentids=" + departmentids + ", userinfoids=" + userinfoids + ", stationids=" + stationids
				+ ", deptids=" + deptids + ", userids=" + userids + ", departmentnames=" + departmentnames
				+ ", stationnames=" + stationnames + ", deptnames=" + deptnames + ", usernames=" + usernames
				+ ", groupnames=" + groupnames + ", ismerchantuser=" + ismerchantuser + ", createtime=" + createtime
				+ ", logincount=" + logincount + ", groupids=" + groupids + ", roles=" + roles + "]";
	}
    
	
}