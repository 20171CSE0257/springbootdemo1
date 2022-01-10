package com.example.springbootapp.error;

public class DepartmentNotFoundExcpetion extends Exception{
    public DepartmentNotFoundExcpetion() {
        super();
    }

    public DepartmentNotFoundExcpetion(String message) {
        super(message);
    }

    public DepartmentNotFoundExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundExcpetion(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
