package com.test.demo.controller;

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
@RequestMapping("/login")
public class StudentLoginController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/getStudentList")
    public ResponseModel<Page<Student>> getStudentList() {
        ResponseModel<Page<Student>> result = null;
        try {
            Page<Student> stuList = studentService.getStudentList(new Page<>(1, 10));
            result = new ResponseModel<>("success", "查询成功！", stuList);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseModel<>("error", "查询异常！");
        }
        return result;
    }


}
