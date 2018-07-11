package com.test.demo.po;

import java.io.Serializable;

/**
 * 系统用户实体
 *
 * @author Ben
 * @create 2018-07-05 11:27
 **/
public class SysUserInfo  implements Serializable {

        //主键
        private String userId;
        //用户名
        private String userName;
        //密码
        private String userPassword;
        //邮箱
        private String userEmail;
        //地址
        private String userAddr;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }
}
