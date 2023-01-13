package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.GlobalCustomException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.NaoEncontradoException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.VeiculoExiste;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDePasseio;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository.VeiculoDePasseioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VeiculoDePasseioService {
    
    private final VeiculoDePasseioRepository veiculoDePasseioRepository;

    public VeiculoDePasseio save(VeiculoDePasseio veiculoDePasseio) throws GlobalCustomException {
        if (veiculoDePasseioRepository.existsByPlaca(veiculoDePasseio.getPlaca())) {
            throw new VeiculoExiste("A placa enviada ja esta registrada em um veiculo no sistema.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    public VeiculoDePasseio updateById(VeiculoDePasseio veiculoDePasseio) throws GlobalCustomException {
        findById(veiculoDePasseio.getId());
        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    public void deleteById(Long id) throws GlobalCustomException {
        findById(id);
        veiculoDePasseioRepository.deleteById(id);
    }

    public void deleteByPlaca(String placa) throws GlobalCustomException {
        VeiculoDePasseio veiculoDePasseio = findByPlaca(placa);
        veiculoDePasseioRepository.delete(veiculoDePasseio);
    }
    
    public List<VeiculoDePasseio> findByNome(String nome) throws GlobalCustomException {
        return veiculoDePasseioRepository.findByNome(nome).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo com o nome: ".concat(nome)));
    }

    public VeiculoDePasseio findByPlaca(String placa) throws GlobalCustomException {
        return veiculoDePasseioRepository.findByPlaca(placa).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo com a placa: ".concat(placa)));
    }

    public VeiculoDePasseio findById(Long id) throws GlobalCustomException {
        return veiculoDePasseioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo de id: ".concat(id.toString())));
    }

    public List<VeiculoDePasseio> findAll() {
        return veiculoDePasseioRepository.findAll();
    }
}
