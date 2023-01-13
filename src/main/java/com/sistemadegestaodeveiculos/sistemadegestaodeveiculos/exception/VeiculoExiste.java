package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception;

import org.springframework.http.HttpStatus;

public class VeiculoExiste extends GlobalCustomException {

    public VeiculoExiste(String message, HttpStatus codigoHttp) {
        super(message, codigoHttp);
    }

    public VeiculoExiste(String message) {
        super(message);
    }
    
}
