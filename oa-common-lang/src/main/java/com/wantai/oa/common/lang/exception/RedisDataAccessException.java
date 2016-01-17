package com.wantai.oa.common.lang.exception;

public class RedisDataAccessException extends RuntimeException{

    private static final long serialVersionUID = -5751463445862313761L;

    public RedisDataAccessException() {
        super();
    }

    public RedisDataAccessException(String message) {
        super(message);
    }

    public RedisDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public RedisDataAccessException(Throwable cause) {
        super(cause);
    }

    protected RedisDataAccessException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}