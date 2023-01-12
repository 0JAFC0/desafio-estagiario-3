package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDeCarga;

public interface VeiculoDeCargaRepository extends JpaRepository<VeiculoDeCarga, Long> {
    
    public Optional<List<VeiculoDeCarga>> findByNome(String nomeDoVeiculo);

    public Optional<VeiculoDeCarga> findByPlaca(String placa);
}
