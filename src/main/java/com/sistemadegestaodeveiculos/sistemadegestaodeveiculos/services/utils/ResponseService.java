package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.shared.Response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ResponseService {
    
    private final MessageService messageService;
    
    // Serviço responsavel por lidar com requisições HTTP de forma organizada
    public <T> ResponseEntity<Response<T>> create(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<T>(data));
    }

    public <T> ResponseEntity<Response<T>> ok(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<T>(data));
    }

    public <T> ResponseEntity<Response<String>> ok(String messageSource) {
        return ResponseEntity.ok(new Response<String>(messageSource));
    }

    public <T> ResponseEntity<Response<String>> ok(String messageSource, String text) {
        return ResponseEntity.ok(new Response<String>(messageService.getMessage(messageSource) + text));
    }

    public ResponseEntity<String> noContent() {
        return ResponseEntity.noContent().build();
    }
}
