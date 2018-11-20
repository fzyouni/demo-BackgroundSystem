package com.test.demo.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 读取excel文件流转换JavaBean column=>对应的字段
 */
@Target(ElementType.FIELD) //注解的作用域
@Retention(RetentionPolicy.RUNTIME) //注解的运行时间
public @interface ReadExcelAnnotation {

    //排序号对应excel
    int order();
}
