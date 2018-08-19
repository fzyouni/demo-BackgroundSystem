package com.test.demo.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.demo.common.Exception.ServiceException;
import com.test.demo.po.Student;

import java.sql.SQLException;


public interface IStudentService {

    Page<Student> getStudentList(Page<Student> page) throws ServiceException, SQLException;
}
