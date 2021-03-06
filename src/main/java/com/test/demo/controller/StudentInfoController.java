package com.test.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.demo.common.enums.CodeType;
import com.test.demo.common.msg.ResponseModel;
import com.test.demo.po.Student;
import com.test.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ben
 * @create 2018-06-08 13:30
 **/
@RestController
@RequestMapping("/stu")
public class StudentInfoController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/getStudentList")
    public ResponseModel<Page<Student>> getStudentList() {
        ResponseModel<Page<Student>> result;
        try {
            Page<Student> stuList = studentService.getStudentList(new Page<>(1, 10));
            result = new ResponseModel<>(CodeType.SUCCESS, "查询成功！", stuList);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>(CodeType.ERROR, "查询异常！");
        }
        return result;
    }


    @RequestMapping("/getStudentListByCondition")
    public ResponseModel<Student> getStudentListByCondition(String tid) {
        ResponseModel<Student> result;
        try {
            Student stu = studentService.findStudentInfo(tid);
            result = new ResponseModel<>(CodeType.SUCCESS, "", stu);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>(CodeType.ERROR, "");
        }
        return result;
    }


}
