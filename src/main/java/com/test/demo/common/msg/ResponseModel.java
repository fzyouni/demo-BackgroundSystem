package com.test.demo.common.msg;

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
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;



    public ResponseModel(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResponseModel(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
