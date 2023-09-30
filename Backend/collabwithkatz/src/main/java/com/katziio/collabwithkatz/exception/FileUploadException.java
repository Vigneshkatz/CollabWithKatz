package com.katziio.collabwithkatz.dto.error;

public class FileUploadException extends RuntimeException {
    public FileUploadException(String message) {
        super("File upload failed: " + message);
    }
}