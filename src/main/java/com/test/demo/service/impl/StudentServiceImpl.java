package com.test.demo.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.test.demo.mapper.StudentMapper;
import com.test.demo.po.Student;
import com.test.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


/**
 * @author Ben
 * @create 2018-06-08 13:29
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page<Student> getStudentList(Page<Student> page) {
        try {
            page.setRecords(studentMapper.findStudentInfos(page));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
