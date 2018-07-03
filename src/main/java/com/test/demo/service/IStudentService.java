package com.test.demo.service;


import com.test.demo.common.Exception.ServiceException;
import com.test.demo.po.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudentList() throws ServiceException;
}
