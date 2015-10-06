package com.gft.repository;

/**
 * Created by iozi on 06/10/2015.
 */
public class DataAccessException extends Exception {

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException() {
    }
}
