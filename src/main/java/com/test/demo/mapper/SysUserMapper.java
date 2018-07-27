package com.test.demo.mapper;

import com.test.demo.po.SysUserInfo;
import com.test.demo.po.vo.SysUserInfoVo;

import java.util.List;
import java.util.Map;

/**
 * 用户权限信息
 */
public interface SysUserMapper {
    /**
     * 根据用户名获取用户信息
     * @param name
     */
    SysUserInfoVo getUserInfoByName(String name);

    /**
     * 获取用户信息列表
     * @return
     */
    List<SysUserInfo> getUserInfoList(Map<String,Object> params);
}
