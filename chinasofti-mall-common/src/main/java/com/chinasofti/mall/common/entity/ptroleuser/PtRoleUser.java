package com.chinasofti.mall.common.entity.ptroleuser;

public class PtRoleUser {
    private String ids;

    private String roleIds;

    private String moduleIds;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    public String getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(String moduleIds) {
        this.moduleIds = moduleIds == null ? null : moduleIds.trim();
    }
}