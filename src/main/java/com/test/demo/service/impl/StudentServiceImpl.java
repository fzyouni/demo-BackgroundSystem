package com.test.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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



    @Override
    public Page<Student> getStudentList(Page<Student> page) {
        try {
            page.setRecords(baseMapper.findStudentInfos(page));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public Student findStudentInfo(String tid) {
        Student stu = null;
        try {
            stu = baseMapper.findStudentInfo(new QueryWrapper<Student>().eq("tid", tid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stu;
    }


}
