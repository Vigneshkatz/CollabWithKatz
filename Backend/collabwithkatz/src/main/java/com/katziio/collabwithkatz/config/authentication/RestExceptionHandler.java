package com.katziio.collabwithkatz.config.authentication;

import com.katziio.collabwithkatz.dto.error.errorDTO;
import com.katziio.collabwithkatz.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<errorDTO.ErrorDto> handleException(AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new errorDTO.ErrorDto(ex.getMessage()));
    }
}