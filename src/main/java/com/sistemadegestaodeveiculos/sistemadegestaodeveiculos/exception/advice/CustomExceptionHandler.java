package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.GlobalCustomException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.shared.Response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {GlobalCustomException.class})
    public ResponseEntity<Response<?>> handleGlobalCustomException(GlobalCustomException exception) {
        Response<?> error = new Response<>();
        error.addErro(exception.getMessage());
        return new ResponseEntity<>(error, exception.getCodigoHttp());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Response<?>> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        Response<?> error = new Response<>();
        error.addErro(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Response<?>> handleException(MethodArgumentNotValidException exception) {
        Response<?> errorResponse = new Response<>();
        exception.getBindingResult().getFieldErrors().forEach(erro -> {
            errorResponse.addErro(erro.getDefaultMessage());
        });
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
