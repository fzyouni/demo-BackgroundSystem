package com.test.demo.service;


import com.test.demo.po.SysUserInfo;
import com.test.demo.po.vo.SysUserInfoVo;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取全部的用户信息列表
     * @return
     */
    List<SysUserInfo> getUserInfoList(Map<String,Object> params);
}
