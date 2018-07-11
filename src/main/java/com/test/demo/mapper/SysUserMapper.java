package com.test.demo.mapper;

import com.test.demo.po.vo.SysUserInfoVo;

/**
 * 用户权限信息
 */
public interface SysUserMapper {
    /**
     * 根据用户名获取用户信息
     * @param name
     */
    SysUserInfoVo getUserInfoByName(String name);
}
