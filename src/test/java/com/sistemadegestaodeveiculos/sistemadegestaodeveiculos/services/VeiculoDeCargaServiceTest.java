package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.NaoEncontradoException;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.exception.VeiculoExiste;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDeCarga;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository.VeiculoDeCargaRepository;

@ExtendWith(MockitoExtension.class)
class VeiculoDeCargaServiceTest {

    @Mock
    private VeiculoDeCargaRepository veiculoDeCargaRepository;
    @InjectMocks
    private VeiculoDeCargaService veiculoDeCargaService;

    @BeforeEach
    void setUp() {
        veiculoDeCargaService = new VeiculoDeCargaService(veiculoDeCargaRepository);
    }

    @Test
    @DisplayName("Deve Salvar um veiculo com sucesso")
    void testSaveComSucesso() {
        // veiculo
        VeiculoDeCarga veiculoDeCarga = new VeiculoDeCarga();
        veiculoDeCarga.setMarca("Ford");
        veiculoDeCarga.setNome("F-350");
        veiculoDeCarga.setPlaca("XYZ-9876");
        veiculoDeCarga.setQuantidadeDeCarrocerias(2);
        veiculoDeCarga.setCapacidade(10000);

        // quando
        veiculoDeCargaService.save(veiculoDeCarga);

        // então
        ArgumentCaptor<VeiculoDeCarga> veiculoArgumentCaptor = ArgumentCaptor.forClass(VeiculoDeCarga.class);
        verify(veiculoDeCargaRepository).save(veiculoArgumentCaptor.capture());
        assertEquals(veiculoArgumentCaptor.getValue(), veiculoDeCarga);
    }

    @Test
    @DisplayName("Deve salvar um veiculo com uma placa ja existente causando VeiculoExite")
    void testQuandoJaExisteUmVeiculoComPlacaSalva() {
        // veiculo
        VeiculoDeCarga veiculoDeCarga = new VeiculoDeCarga();
        veiculoDeCarga.setMarca("Ford");
        veiculoDeCarga.setNome("F-350");
        veiculoDeCarga.setPlaca("XYZ-9876");
        veiculoDeCarga.setQuantidadeDeCarrocerias(2);
        veiculoDeCarga.setCapacidade(10000);

        when(veiculoDeCargaRepository.existsByPlaca(veiculoDeCarga.getPlaca())).thenReturn(true);

        // quando
        assertThrows(VeiculoExiste.class, () -> veiculoDeCargaService.save(veiculoDeCarga));

        verify(veiculoDeCargaRepository, never()).save(veiculoDeCarga);
    }
    
    @Test
    @DisplayName("Deve pegar todos veiculos com suscesso")
    void testPegarTodosVeiculos() {

        // quando
        veiculoDeCargaService.findAll();

        // então
        verify(veiculoDeCargaRepository).findAll();
    }

    @Test
    @DisplayName("Deve deletar um veiculo pelo id com sucesso")
    void testDeleteById() {
        VeiculoDeCarga veiculo = new VeiculoDeCarga();
        veiculo.setPlaca("XYZ-9876");
        when(veiculoDeCargaRepository.findById(1L)).thenReturn(Optional.of(veiculo));
        
        // quando
        veiculoDeCargaService.deleteById(1L);

        // então
        verify(veiculoDeCargaRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Deve retornar uma exceção de NaoEncontradoException")
    void testDeleteByIdNotFound() {

        when(veiculoDeCargaRepository.findById(1L)).thenReturn(Optional.empty());
        
        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDeCargaService.deleteById(1L));

        // então
        verify(veiculoDeCargaRepository, never()).deleteById(1L);
    }

    @Test
    @DisplayName("Deve deletar um veiculo pela placa com sucesso")
    void testDeleteByPlaca() {

        String placa = "XYZ-9876";

        VeiculoDeCarga veiculo = new VeiculoDeCarga();
        veiculo.setPlaca(placa);

        when(veiculoDeCargaRepository.findByPlaca(placa)).thenReturn(Optional.of(veiculo));

        // quando
        veiculoDeCargaService.deleteByPlaca(placa);

        // então
        verify(veiculoDeCargaRepository, times(1)).delete(veiculo);
    }

    @Test
    @DisplayName("Deve lançar uma exceção de NaoEncontradoException")
    void testDeleteByPlacaNotFound() {

        String placa = "XYZ-9876";
        VeiculoDeCarga veiculo = new VeiculoDeCarga();
        veiculo.setPlaca("XYZ-9876");

        when(veiculoDeCargaRepository.findByPlaca(placa)).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDeCargaService.deleteByPlaca(placa));

        // então
        verify(veiculoDeCargaRepository, never()).delete(veiculo);
    }

    @Test
    @DisplayName("Deve pegar um veiculo pelo id com sucesso")
    void testFindById() {
        //veiculo
        VeiculoDeCarga veiculo = new VeiculoDeCarga();
        veiculo.setPlaca("XYZ-9876");
        when(veiculoDeCargaRepository.findById(1L)).thenReturn(Optional.of(veiculo));
        
        //quando
        VeiculoDeCarga result = veiculoDeCargaService.findById(1L);
        
        //Assert
        assertEquals(veiculo, result);
        verify(veiculoDeCargaRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve lançar uma exceção de NaoEncontradoException")
    void testFindByIdNotFound() {
        //veiculo
        when(veiculoDeCargaRepository.findById(1L)).thenReturn(Optional.empty());
        
        //quando Assert
        assertThrows(NaoEncontradoException.class, () -> veiculoDeCargaService.findById(1L));
        verify(veiculoDeCargaRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve retornar uma lista de veiculos com sucesso")
    void testFindByNome() {

        String nome = "F-350";
        List<VeiculoDeCarga> veiculos = Stream.of(new VeiculoDeCarga(),new VeiculoDeCarga()).collect(Collectors.toList());
        
        when(veiculoDeCargaRepository.findByNome(nome)).thenReturn(Optional.of(veiculos));
        // quando
        veiculoDeCargaService.findByNome(nome);
        // então
        verify(veiculoDeCargaRepository, times(1)).findByNome(nome);
    }

    @Test
    @DisplayName("Deve retornar uma exceção de NaoEncontradoException")
    void testFindByNomeNotFound() {

        String nome = "F-350";
        
        when(veiculoDeCargaRepository.findByNome(nome)).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDeCargaService.findByNome(nome));

        // então
        ArgumentCaptor<String> nomeArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(veiculoDeCargaRepository).findByNome(nomeArgumentCaptor.capture());
        assertEquals(nomeArgumentCaptor.getValue(), nome);
    }

    @Test
    @DisplayName("Deve encontrar um veiculo pela placa com sucesso")
    void testFindByPlaca() {

        String placa = "XYZ-9876";
        VeiculoDeCarga veiculoDeCarga = new VeiculoDeCarga();
        veiculoDeCarga.setPlaca(placa);
        when(veiculoDeCargaRepository.findByPlaca(placa)).thenReturn(Optional.of(veiculoDeCarga));

        // quando
        veiculoDeCargaService.findByPlaca(placa);

        // então
        verify(veiculoDeCargaRepository, times(1)).findByPlaca(placa);
    }

    @Test
    @DisplayName("Deve lançar uma exceção de NaoEncontradoException")
    void testFindByPlacaNotFound() {

        String placa = "XYZ-9876";
        VeiculoDeCarga veiculoDeCarga = new VeiculoDeCarga();
        veiculoDeCarga.setPlaca(placa);
        when(veiculoDeCargaRepository.findByPlaca(placa)).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDeCargaService.findByPlaca(placa));

        // então
        ArgumentCaptor<String> placaArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(veiculoDeCargaRepository, times(1)).findByPlaca(placaArgumentCaptor.capture());
        assertEquals(placaArgumentCaptor.getValue(), placa);
    }

    @Test
    @DisplayName("Deve atualizar o veiculo com o id com sucesso")
    void testUpdateById() {

        // veiculo
        VeiculoDeCarga veiculoDeCarga = new VeiculoDeCarga();
        veiculoDeCarga.setId(1L);
        veiculoDeCarga.setMarca("Ford");
        veiculoDeCarga.setNome("F-350");
        veiculoDeCarga.setPlaca("XYZ-9876");
        veiculoDeCarga.setQuantidadeDeCarrocerias(2);
        veiculoDeCarga.setCapacidade(10000);

        when(veiculoDeCargaRepository.findById(veiculoDeCarga.getId())).thenReturn(Optional.of(veiculoDeCarga));

        // quando
        veiculoDeCargaService.updateById(veiculoDeCarga);

        // então
        ArgumentCaptor<VeiculoDeCarga> veiculoArgumentCaptor = ArgumentCaptor.forClass(VeiculoDeCarga.class);
        verify(veiculoDeCargaRepository,times(1)).save(veiculoArgumentCaptor.capture());
        assertEquals(veiculoArgumentCaptor.getValue(), veiculoDeCarga);
    }

    @Test
    @DisplayName("Deve atualizar o veiculo com o id com sucesso")
    void testUpdateByIdNotFound() {

        // veiculo
        VeiculoDeCarga veiculoDeCarga = new VeiculoDeCarga();
        veiculoDeCarga.setId(1L);
        veiculoDeCarga.setMarca("Ford");
        veiculoDeCarga.setNome("F-350");
        veiculoDeCarga.setPlaca("XYZ-9876");
        veiculoDeCarga.setQuantidadeDeCarrocerias(2);
        veiculoDeCarga.setCapacidade(10000);

        when(veiculoDeCargaRepository.findById(veiculoDeCarga.getId())).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDeCargaService.updateById(veiculoDeCarga));

        // então
        verify(veiculoDeCargaRepository, never()).save(veiculoDeCarga);
    }
}
