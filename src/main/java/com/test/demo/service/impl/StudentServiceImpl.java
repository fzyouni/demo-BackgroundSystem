package com.test.demo.service.impl;

import com.test.demo.common.Exception.ServiceException;
import com.test.demo.mapper.StudentMapper;
import com.test.demo.po.Student;
import com.test.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * @author Ben
 * @create 2018-06-08 13:29
 **/
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() throws ServiceException{
        List<Student> result = null;
        try {
            result = studentMapper.findStudentInfos();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage(), e);
        }
        return result;
    }
}
