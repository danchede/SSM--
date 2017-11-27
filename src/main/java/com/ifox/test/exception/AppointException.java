package com.ifox.test.exception;

/**
 * 预约业务异常
 */
public class AppointException extends  RuntimeException{
    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
