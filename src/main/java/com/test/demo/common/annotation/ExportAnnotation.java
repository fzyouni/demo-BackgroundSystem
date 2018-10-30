package com.test.demo.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * excel 导出对象实体类注解
 */
@Target(ElementType.FIELD) //注解的作用域
@Retention(RetentionPolicy.RUNTIME) //注解的运行时间
public @interface ExportAnnotation {

    //导出行序
    int order() default 0;

    //excel 单元格字段标题
    String fieldName() default "";
}


