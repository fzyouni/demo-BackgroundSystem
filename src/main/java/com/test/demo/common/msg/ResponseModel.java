package com.test.demo.common.msg;

import com.test.demo.common.enums.CodeType;

import java.io.Serializable;

/**
 * 数据返回包装类
 *
 * @author Ben
 * @create 2018-06-08 15:18
 **/
public class ResponseModel<T> implements Serializable {
    /**
     * 返回状态编码
     */
    private CodeType code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;


    public ResponseModel(CodeType code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResponseModel(CodeType code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CodeType getCode() {
        return code;
    }

    public void setCode(CodeType code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
