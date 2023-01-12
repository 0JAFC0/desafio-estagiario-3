package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GlobalCustomException extends RuntimeException {
    
    private final HttpStatus codigoHttp;

    public GlobalCustomException(String message, HttpStatus codigoHttp) {
        super(message);
        this.codigoHttp = codigoHttp;
    }

    public GlobalCustomException(String message) {
        super(message);
        this.codigoHttp = HttpStatus.BAD_REQUEST;
    }
}
