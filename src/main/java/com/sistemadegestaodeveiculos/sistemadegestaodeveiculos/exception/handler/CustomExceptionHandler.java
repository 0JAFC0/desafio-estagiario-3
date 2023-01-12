package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.GlobalCustomException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.utils.MessageService;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.shared.Response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class CustomExceptionHandler {

    private final MessageService messageService;
    
    @ExceptionHandler(value = {GlobalCustomException.class})
    public ResponseEntity<Response<?>> handleException(GlobalCustomException exception) {
        Response<?> error = new Response<>();
        error.addErro(exception.getMessage());
        return new ResponseEntity<>(error, exception.getCodigoHttp());
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<Response<?>> handleException(DataIntegrityViolationException exception) {
        Response<?> error = new Response<>();
        error.addErro(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
