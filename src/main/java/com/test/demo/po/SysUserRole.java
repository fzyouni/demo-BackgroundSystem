package com.test.demo.po;

import java.io.Serializable;

/**
 * 用户角色表实体
 *
 * @author Ben
 * @create 2018-07-05 11:36
 **/
public class SysUserRole implements Serializable {
    //主键
    private String roleId;
    //角色名
    private String roleName;
    //用户Id
    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
