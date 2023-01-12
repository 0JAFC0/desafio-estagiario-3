package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends GlobalCustomException {

    public NaoEncontradoException(String message, HttpStatus codigoHttp) {
        super(message, codigoHttp);
    }

    public NaoEncontradoException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
