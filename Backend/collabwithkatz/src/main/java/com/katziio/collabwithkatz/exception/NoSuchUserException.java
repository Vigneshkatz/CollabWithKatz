package com.katziio.collabwithkatz.exception;


public class NoSuchUserException extends RuntimeException{

    private String message;
    public NoSuchUserException() {}
    public NoSuchUserException(Long id)
    {
        super( "No Such User is found for id :"+id);

        this.message = "No Such User is found for id :"+id;
    }

    public NoSuchUserException(String email)
    {
        super( "No Such User is found for email :"+email);

        this.message = "No Such User is found for email :"+email;
    }

    public NoSuchUserException(String email, String password)
    {
        super( "No Such User is found for email :"+email+" password "+password);

        this.message =  "No Such User is found for email :"+email+" password "+password;
    }

}
