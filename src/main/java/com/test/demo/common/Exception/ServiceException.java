package com.test.demo.common.Exception;

/**
 * 业务逻辑层异常类
 *
 * @author Ben
 * @create 2018-06-08 15:41
 **/
public class ServiceException extends Exception {

    private static final long serialVersionUID = 2L;


    public ServiceException() {
    }


    /**
     * @param message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
