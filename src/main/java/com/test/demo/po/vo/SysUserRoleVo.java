package com.test.demo.po.vo;

import com.test.demo.po.SysUserPermission;
import com.test.demo.po.SysUserRole;

import java.util.List;

/**
 * 角色信息
 *
 * @author Ben
 * @create 2018-07-05 14:34
 **/
public class SysUserRoleVo extends SysUserRole {

    private List<SysUserPermission> permissions;

    public List<SysUserPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysUserPermission> permissions) {
        this.permissions = permissions;
    }
}
