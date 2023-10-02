package com.katziio.collabwithkatz.exception;

public class FileUploadException extends RuntimeException {
    public FileUploadException(String message) {
        super("File upload failed: " + message);
    }
}