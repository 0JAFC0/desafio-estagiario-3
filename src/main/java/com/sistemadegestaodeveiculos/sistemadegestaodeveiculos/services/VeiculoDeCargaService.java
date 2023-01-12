package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.NaoEncontradoException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDeCarga;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository.VeiculoDeCargaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VeiculoDeCargaService {
    
    private final VeiculoDeCargaRepository veiculoDeCargaRepository;

    public VeiculoDeCarga save(VeiculoDeCarga veiculoDeCarga) throws RuntimeException {
        return veiculoDeCargaRepository.save(veiculoDeCarga);
    }

    public VeiculoDeCarga updateById(VeiculoDeCarga veiculoDeCarga) throws RuntimeException {
        findById(veiculoDeCarga.getId());
        return veiculoDeCargaRepository.save(veiculoDeCarga);
    }

    public void deleteByPlaca(String placa) throws RuntimeException {
        veiculoDeCargaRepository.delete(findByPlaca(placa));
    }

    public void deleteById(Long id) throws RuntimeException {
        findById(id);
        veiculoDeCargaRepository.deleteById(id);
    }
    
    public List<VeiculoDeCarga> findByNome(String nome) throws RuntimeException {
        return veiculoDeCargaRepository.findByNome(nome).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar nenhum veiculo com o nome: ".concat(nome), HttpStatus.NOT_FOUND));
    }

    public VeiculoDeCarga findByPlaca(String placa) throws RuntimeException {
        return veiculoDeCargaRepository.findByPlaca(placa).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo com a placa: ".concat(placa), HttpStatus.NOT_FOUND));
    }

    public VeiculoDeCarga findById(Long id) throws RuntimeException {
        return veiculoDeCargaRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo de id: ".concat(id.toString()), HttpStatus.NOT_FOUND));
    }

    public List<VeiculoDeCarga> findAll() {
        return veiculoDeCargaRepository.findAll();
    }
}
