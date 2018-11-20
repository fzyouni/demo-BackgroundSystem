package com.test.demo;

import com.test.demo.common.utils.ExcelUtils;
import com.test.demo.po.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("1","张三","合肥市","18555119261","1"));
        list.add(new Student("2","李四","池州市","18555119262","1"));
        list.add(new Student("3","王五","铜陵市","18555119263","1"));
        list.add(new Student("4","张三丰","安庆市","18555119264","1"));
        list.add(new Student("5","春十三娘","芜湖市","18555119265","1"));
        list.add(new Student("6","孙悟空","巢湖市","18555119266","1"));
        list.add(new Student("7","猪八戒","淮北市","18555119267","1"));
        list.add(new Student("8","唐三藏","大唐","18555119268","1"));
        list.add(new Student("9","沙悟净","啊啊啊","18555119269","1"));
    }
}
