package com.katziio.collabwithkatz.exception;

public class NoChatFoundException extends RuntimeException{

    private String message;
    public NoChatFoundException() {}


    public NoChatFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
