package com.test.demo.po.vo;

import com.test.demo.po.SysUserInfo;


import java.util.List;

/**
 * 用户信息的vo
 *
 * @author Ben
 * @create 2018-07-05 14:16
 **/
public class SysUserInfoVo extends SysUserInfo {

    private List<SysUserRoleVo> roles;

    public List<SysUserRoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<SysUserRoleVo> roles) {
        this.roles = roles;
    }
}
