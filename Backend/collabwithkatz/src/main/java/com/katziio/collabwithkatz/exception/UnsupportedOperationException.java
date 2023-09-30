package com.katziio.collabwithkatz.dto.error;

public class UnsupportedOperationException extends RuntimeException {
    public UnsupportedOperationException(String operation) {
        super("Unsupported operation: " + operation);
    }
}
