package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception;

import org.springframework.http.HttpStatus;

public class CampoVazioException extends GlobalCustomException {

    public CampoVazioException(String message, HttpStatus codigoHttp) {
        super(message, codigoHttp);
    }

    public CampoVazioException(String message) {
        super(message,HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
