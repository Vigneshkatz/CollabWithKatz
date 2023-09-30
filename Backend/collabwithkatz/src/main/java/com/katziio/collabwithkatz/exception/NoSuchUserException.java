package com.katziio.collabwithkatz.dto.error;

public class NoSuchUserException extends RuntimeException{

    private String message;
    public NoSuchUserException() {}

    public NoSuchUserException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
