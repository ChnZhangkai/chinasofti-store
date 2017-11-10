package com.chinasofti.mall.common.entity;

import java.util.List;

public class PtMenu {
    private String ids;

    private String menuname;

    private String url;

    private String pids;

    private String ceratetime;

    private String createby;

    private String updatetime;

    private String updateby;
    
    private List<PtMenu> childMenu;
    

    public List<PtMenu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<PtMenu> childMenu) {
		this.childMenu = childMenu;
	}

	public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    public String getCeratetime() {
        return ceratetime;
    }

    public void setCeratetime(String ceratetime) {
        this.ceratetime = ceratetime == null ? null : ceratetime.trim();
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

	@Override
	public String toString() {
		return "PtMenu [ids=" + ids + ", menuname=" + menuname + ", url=" + url + ", pids=" + pids + "]";
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
		PtMenu other = (PtMenu) obj;
		if (ids == null) {
			if (other.ids != null)
				return false;
		} else if (!ids.equals(other.ids))
			return false;
		return true;
	}
    
}