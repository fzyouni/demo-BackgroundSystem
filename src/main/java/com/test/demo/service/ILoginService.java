package com.test.demo.service;


import com.test.demo.po.vo.SysUserInfoVo;

/**
 * 权限用户登录接口
 *
 * @author Ben
 * @create 2018-07-05 10:54
 **/
public interface ILoginService {
    /**
     * 根据登录名获取用户信息
     *
     * @param name
     * @return
     */
    SysUserInfoVo getUserInfoByName(String name);
}
