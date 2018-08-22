package com.test.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.demo.common.msg.ResponseModel;
import com.test.demo.po.Student;
import com.test.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
        ResponseModel<Page<Student>> result = null;
        try {
            Page<Student> stuList = studentService.getStudentList(new Page<Student>(1, 10));
            result = new ResponseModel<>("success", "查询成功！", stuList);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>("error", "查询异常！");
        }
        return result;
    }

    @RequestMapping("/getStudentListByCondition")
    public ResponseModel<Student> getStudentListByCondition(String tid) {
        ResponseModel<Student> result;
        try {
            Student stu = studentService.findStudentInfo(tid);
            result = new ResponseModel<>("success", "", stu);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>("error", "");
        }
        return result;
    }


}
