package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private T data;
    private List<String> erros = new ArrayList<>();
    private List<String> links = new ArrayList<>();

    public Response(T data) {
        super();
        this.data = data;
    }

    public void addErro(String messageError) {
        this.erros.add(messageError);
    }
}
