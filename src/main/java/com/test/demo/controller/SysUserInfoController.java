package com.test.demo.controller;


import com.google.common.collect.Maps;
import com.test.demo.common.enums.CodeType;
import com.test.demo.common.msg.ResponseModel;
import com.test.demo.po.SysUserInfo;
import com.test.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Map<String, Object> params = Maps.newHashMap();
        params.put("name", request.getParameter("name"));
        params.put("addr", request.getParameter("addr"));
        ResponseModel<List<SysUserInfo>> result = null;
        try {
            List<SysUserInfo> res = loginService.getUserInfoList(params);
            result = new ResponseModel<>(CodeType.SUCCESS, "", res);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>(CodeType.ERROR, "数据加载异常！");
        }
        return result;
    }

}
