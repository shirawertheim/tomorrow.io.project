package com.example.demo.Controllers;


import com.example.demo.POJO.ExceptionEntity.ErrorDetail;
import com.example.demo.POJO.ExceptionEntity.ErrorResponse;
import com.example.demo.POJO.ExceptionEntity.Types.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidOperatorException(BadRequestException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus("error");
        errorResponse.setError(new ErrorDetail(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}