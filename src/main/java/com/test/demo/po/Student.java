package com.test.demo.po;


import java.io.Serializable;
import java.util.Date;

/**
 * 学生信息实体类
 *
 * @author Ben
 * @create 2018-06-08 13:45
 **/
public class Student implements Serializable {

    //主键
    private String tid;
    //姓名
    private String stuName;
    //地址
    private String stuAddr;
    //电话
    private String stuPhone;
    //状态（0：未删除 1：已删除）
    private String stuState;
    //用户密码
    private String stuPassword;
    //创建时间
    private Date createTime;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAddr() {
        return stuAddr;
    }

    public void setStuAddr(String stuAddr) {
        this.stuAddr = stuAddr;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuState() {
        return stuState;
    }

    public void setStuState(String stuState) {
        this.stuState = stuState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }
}
