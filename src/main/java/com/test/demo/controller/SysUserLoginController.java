package com.test.demo.controller;


import com.test.demo.common.enums.CodeType;
import com.test.demo.common.msg.ResponseModel;
import com.test.demo.po.SysUserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限用户登陆controller
 *
 * @author Ben
 * @create 2018-07-06 13:48
 **/
@RestController
@RequestMapping("/sys")
public class SysUserLoginController {


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ResponseModel<SysUserInfo> sysLogin(SysUserInfo userInfo) {
        ResponseModel<SysUserInfo> result;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(), userInfo.getUserPassword());
        try {
            subject.login(token);
            result = new ResponseModel<>(CodeType.SUCCESS, "登陆成功！", userInfo);
        } catch (IncorrectCredentialsException e) {
            result = new ResponseModel<>(CodeType.ERROR, "密码错误！");
        } catch (LockedAccountException e) {
            result = new ResponseModel<>(CodeType.ERROR, "该账户已被冻结！");
        } catch (AuthenticationException e) {
            result = new ResponseModel<>(CodeType.ERROR, "该账户不存在！");
        } catch (Exception e) {
            result = new ResponseModel<>(CodeType.ERROR, "登陆异常！");
        }
        return result;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/unLogin")
    public ResponseModel<String> unLogin() {
        return new ResponseModel<>(CodeType.ERROR, "未登录");
    }
}
