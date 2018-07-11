package com.test.demo.shiroRealm;



import com.test.demo.po.SysUserPermission;
import com.test.demo.service.ILoginService;
import com.test.demo.po.vo.SysUserInfoVo;
import com.test.demo.po.vo.SysUserRoleVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * 实现realm接口用户认证
 *
 * @author Ben
 * @create 2018-07-05 10:51
 **/
public class MyShiroRealm extends AuthorizingRealm {

    /**
     * 用户登录实现注入
     */
    @Autowired
    private ILoginService loginService;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //获取用户信息
        SysUserInfoVo userInfo = loginService.getUserInfoByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (SysUserRoleVo role : userInfo.getRoles()) {//遍历用户的角色信息
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (SysUserPermission permission : role.getPermissions()) {//遍历角色的权限信息
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }
    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {//加这一步的目的是在Post请求的时候会先进认证，然后在到请求
            return null;
        }
        //获取用户登录名
        String name = authenticationToken.getPrincipal().toString();
        //获取用户信息
        SysUserInfoVo userInfo = loginService.getUserInfoByName(name);
        if (userInfo == null) {
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, userInfo.getUserPassword(), getName());
            return simpleAuthenticationInfo;

        }
    }
}
