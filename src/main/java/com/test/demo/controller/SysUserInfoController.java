package com.test.demo.controller;


import com.test.demo.common.msg.ResponseModel;
import com.test.demo.po.SysUserInfo;
import com.test.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统用户信息
 *
 * @author Ben
 * @create 2018-07-20 17:25
 **/
@RestController
@RequestMapping("user")
public class SysUserInfoController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "getUserInfoList", method = RequestMethod.POST)
    public ResponseModel<List<SysUserInfo>> getUserInfoList() {
        ResponseModel<List<SysUserInfo>> result = null;
        try {
            List<SysUserInfo> res = loginService.getUserInfoList();
            result = new ResponseModel<>("success", "", res);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>("error", "数据加载异常！");
        }
        return result;
    }
}
