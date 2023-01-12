package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.NaoEncontradoException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDePasseio;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository.VeiculoDePasseioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VeiculoDePasseioService {
    
    private final VeiculoDePasseioRepository veiculoDePasseioRepository;

    public VeiculoDePasseio save(VeiculoDePasseio veiculoDePasseio) {
        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    public VeiculoDePasseio updateById(VeiculoDePasseio veiculoDePasseio) throws RuntimeException {
        findById(veiculoDePasseio.getId());
        return veiculoDePasseioRepository.save(veiculoDePasseio);
    }

    public void deleteById(Long id) throws RuntimeException {
        findById(id);
        veiculoDePasseioRepository.deleteById(id);
    }

    public void deleteByPlaca(String placa) throws RuntimeException {
        VeiculoDePasseio veiculoDePasseio = findByPlaca(placa);
        veiculoDePasseioRepository.delete(veiculoDePasseio);
    }
    
    public List<VeiculoDePasseio> findByNome(String nome) throws RuntimeException {
        return veiculoDePasseioRepository.findByNome(nome).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo com o nome: ".concat(nome)));
    }

    public VeiculoDePasseio findByPlaca(String placa) throws RuntimeException {
        return veiculoDePasseioRepository.findByPlaca(placa).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo com a placa: ".concat(placa)));
    }

    public VeiculoDePasseio findById(Long id) throws RuntimeException {
        return veiculoDePasseioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Não foi possivel encontrar o veiculo de id: ".concat(id.toString())));
    }

    public List<VeiculoDePasseio> findAll() {
        return veiculoDePasseioRepository.findAll();
    }
}
