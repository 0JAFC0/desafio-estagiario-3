package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDePasseio;

public interface VeiculoDePasseioRepository extends JpaRepository<VeiculoDePasseio, Long> {
    
    public Optional<List<VeiculoDePasseio>> findByNome(String nomeDoVeiculo);

    public Optional<VeiculoDePasseio> findByPlaca(String placa);
}
