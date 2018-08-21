package com.test.demo.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.demo.po.Student;


public interface IStudentService {

    Page<Student> getStudentList(Page<Student> page);

    Student findStudentInfo(String tid);
}
