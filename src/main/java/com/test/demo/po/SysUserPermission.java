package com.test.demo.po;

import java.io.Serializable;

/**
 * 角色权限表
 *
 * @author Ben
 * @create 2018-07-05 11:35
 **/
public class SysUserPermission implements Serializable {
    //主键
    private String tid;
    //权限
    private String permission;
    //角色Id
    private String roleId;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
