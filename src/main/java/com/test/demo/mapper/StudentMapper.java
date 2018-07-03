package com.test.demo.mapper;

import com.test.demo.po.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 学生信息dto 接口
 */
public interface StudentMapper {
    /**
     * 新增学生信息
     *
     * @param model
     * @return
     */
    Student insertStudentInfo(Student model) throws SQLException;

    /**
     * 修改学生信息
     *
     * @param model
     */
    void updateStudentInfo(Student model) throws SQLException;

    /**
     * 删除学生信息
     *
     * @param tid
     */
    void deleteStudentInfo(String tid) throws SQLException;

    /**
     * 查询全部的学生信息
     *
     * @return
     */
    List<Student> findStudentInfos() throws SQLException;

    /**
     * 根据主键查询出对应的学生信息
     *
     * @param tid
     * @return
     */
    Student findStudentInfo(String tid) throws SQLException;


}
