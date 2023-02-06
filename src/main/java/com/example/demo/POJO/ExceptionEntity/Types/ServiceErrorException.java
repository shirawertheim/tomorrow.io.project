package com.example.demo.POJO.ExceptionEntity.Types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceErrorException extends RuntimeException {

    public ServiceErrorException(String message) {
        super(message);
    }
}

