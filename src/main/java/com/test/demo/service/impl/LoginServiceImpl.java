package com.test.demo.service.impl;


import com.test.demo.mapper.SysUserMapper;
import com.test.demo.po.SysUserInfo;
import com.test.demo.service.ILoginService;
import com.test.demo.po.vo.SysUserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户登录业务实现类
 *
 * @author Ben
 * @create 2018-07-05 10:55
 **/
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserInfoVo getUserInfoByName(String name) {
        SysUserInfoVo userInfo = null;
        try {
            userInfo = sysUserMapper.getUserInfoByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public List<SysUserInfo> getUserInfoList() {
        List<SysUserInfo> result = null;
        try {
            result = sysUserMapper.getUserInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
