package com.katziio.collabwithkatz.exception;

public class UnsupportedOperationException extends RuntimeException {
    public UnsupportedOperationException(String operation) {
        super("Unsupported operation: " + operation);
    }
}
