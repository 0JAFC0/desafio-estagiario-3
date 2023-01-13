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
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDePasseio;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository.VeiculoDePasseioRepository;

@ExtendWith(MockitoExtension.class)
public class VeiculoDePasseioServiceTest {

    @Mock
    private VeiculoDePasseioRepository veiculoDePasseioRepository;
    @InjectMocks
    private VeiculoDePasseioService veiculoDePasseioService;

    @BeforeEach
    void setUp() {
        veiculoDePasseioService = new VeiculoDePasseioService(veiculoDePasseioRepository);
    }

    @Test
    @DisplayName("Deve Salvar um veiculo com sucesso")
    void testSaveComSucesso() {
        // veiculo
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setMarca("Ford");
        veiculoDePasseio.setNome("Focus");
        veiculoDePasseio.setPlaca("ABC-1234");
        veiculoDePasseio.setNumeroDePassageiros(5);

        // quando
        veiculoDePasseioService.save(veiculoDePasseio);

        // então
        ArgumentCaptor<VeiculoDePasseio> veiculoArgumentCaptor = ArgumentCaptor.forClass(VeiculoDePasseio.class);
        verify(veiculoDePasseioRepository).save(veiculoArgumentCaptor.capture());
        assertEquals(veiculoArgumentCaptor.getValue(), veiculoDePasseio);
    }

    @Test
    @DisplayName("Deve salvar um veiculo com uma placa ja existente causando VeiculoExite")
    void testQuandoJaExisteUmVeiculoComPlacaSalva() {
        // veiculo
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setMarca("Ford");
        veiculoDePasseio.setNome("Focus");
        veiculoDePasseio.setPlaca("ABC-1234");
        veiculoDePasseio.setNumeroDePassageiros(5);

        when(veiculoDePasseioRepository.existsByPlaca(veiculoDePasseio.getPlaca())).thenReturn(true);

        // quando
        assertThrows(VeiculoExiste.class, () -> veiculoDePasseioService.save(veiculoDePasseio));

        verify(veiculoDePasseioRepository, never()).save(veiculoDePasseio);
    }
    
    @Test
    @DisplayName("Deve pegar todos veiculos com suscesso")
    void testPegarTodosVeiculos() {

        // quando
        veiculoDePasseioService.findAll();

        // então
        verify(veiculoDePasseioRepository).findAll();
    }

    @Test
    @DisplayName("Deve deletar um veiculo pelo id com sucesso")
    void testDeleteById() {
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setPlaca("ABC-1234");
        when(veiculoDePasseioRepository.findById(1L)).thenReturn(Optional.of(veiculoDePasseio));
        
        // quando
        veiculoDePasseioService.deleteById(1L);

        // então
        verify(veiculoDePasseioRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Deve retornar uma exceção de NaoEncontradoException")
    void testDeleteByIdNotFound() {

        when(veiculoDePasseioRepository.findById(1L)).thenReturn(Optional.empty());
        
        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDePasseioService.deleteById(1L));

        // então
        verify(veiculoDePasseioRepository, never()).deleteById(1L);
    }

    @Test
    @DisplayName("Deve deletar um veiculo pela placa com sucesso")
    void testDeleteByPlaca() {

        String placa = "XYZ-9876";

        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setPlaca(placa);

        when(veiculoDePasseioRepository.findByPlaca(placa)).thenReturn(Optional.of(veiculoDePasseio));

        // quando
        veiculoDePasseioService.deleteByPlaca(placa);

        // então
        verify(veiculoDePasseioRepository, times(1)).delete(veiculoDePasseio);
    }

    @Test
    @DisplayName("Deve lançar uma exceção de NaoEncontradoException")
    void testDeleteByPlacaNotFound() {

        String placa = "XYZ-9876";
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setPlaca("XYZ-9876");

        when(veiculoDePasseioRepository.findByPlaca(placa)).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDePasseioService.deleteByPlaca(placa));

        // então
        verify(veiculoDePasseioRepository, never()).delete(veiculoDePasseio);
    }

    @Test
    @DisplayName("Deve pegar um veiculo pelo id com sucesso")
    void testFindById() {
        //veiculo
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setPlaca("XYZ-9876");
        when(veiculoDePasseioRepository.findById(1L)).thenReturn(Optional.of(veiculoDePasseio));
        
        //quando
        VeiculoDePasseio result = veiculoDePasseioService.findById(1L);
        
        //Assert
        assertEquals(veiculoDePasseio, result);
        verify(veiculoDePasseioRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve lançar uma exceção de NaoEncontradoException")
    void testFindByIdNotFound() {
        //veiculo
        when(veiculoDePasseioRepository.findById(1L)).thenReturn(Optional.empty());
        
        //quando Assert
        assertThrows(NaoEncontradoException.class, () -> veiculoDePasseioService.findById(1L));
        verify(veiculoDePasseioRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve retornar uma lista de veiculos com sucesso")
    void testFindByNome() {

        String nome = "F-350";
        List<VeiculoDePasseio> veiculos = Stream.of(new VeiculoDePasseio(),new VeiculoDePasseio()).collect(Collectors.toList());
        
        when(veiculoDePasseioRepository.findByNome(nome)).thenReturn(Optional.of(veiculos));
        // quando
        veiculoDePasseioService.findByNome(nome);
        // então
        verify(veiculoDePasseioRepository, times(1)).findByNome(nome);
    }

    @Test
    @DisplayName("Deve retornar uma exceção de NaoEncontradoException")
    void testFindByNomeNotFound() {

        String nome = "F-350";
        
        when(veiculoDePasseioRepository.findByNome(nome)).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDePasseioService.findByNome(nome));

        // então
        ArgumentCaptor<String> nomeArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(veiculoDePasseioRepository).findByNome(nomeArgumentCaptor.capture());
        assertEquals(nomeArgumentCaptor.getValue(), nome);
    }

    @Test
    @DisplayName("Deve encontrar um veiculo pela placa com sucesso")
    void testFindByPlaca() {

        String placa = "XYZ-9876";
        VeiculoDePasseio veiculoDeCarga = new VeiculoDePasseio();
        veiculoDeCarga.setPlaca(placa);
        when(veiculoDePasseioRepository.findByPlaca(placa)).thenReturn(Optional.of(veiculoDeCarga));

        // quando
        veiculoDePasseioService.findByPlaca(placa);

        // então
        verify(veiculoDePasseioRepository, times(1)).findByPlaca(placa);
    }

    @Test
    @DisplayName("Deve lançar uma exceção de NaoEncontradoException")
    void testFindByPlacaNotFound() {

        String placa = "XYZ-9876";
        VeiculoDePasseio veiculoDeCarga = new VeiculoDePasseio();
        veiculoDeCarga.setPlaca(placa);
        when(veiculoDePasseioRepository.findByPlaca(placa)).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDePasseioService.findByPlaca(placa));

        // então
        ArgumentCaptor<String> placaArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(veiculoDePasseioRepository, times(1)).findByPlaca(placaArgumentCaptor.capture());
        assertEquals(placaArgumentCaptor.getValue(), placa);
    }

    @Test
    @DisplayName("Deve atualizar o veiculo com o id com sucesso")
    void testUpdateById() {

        // veiculo
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setId(1L);
        veiculoDePasseio.setMarca("Ford");
        veiculoDePasseio.setNome("Focus");
        veiculoDePasseio.setPlaca("ABC-1234");
        veiculoDePasseio.setNumeroDePassageiros(5);
        
        when(veiculoDePasseioRepository.findById(veiculoDePasseio.getId())).thenReturn(Optional.of(veiculoDePasseio));

        // quando
        veiculoDePasseioService.updateById(veiculoDePasseio);

        // então
        ArgumentCaptor<VeiculoDePasseio> veiculoArgumentCaptor = ArgumentCaptor.forClass(VeiculoDePasseio.class);
        verify(veiculoDePasseioRepository,times(1)).save(veiculoArgumentCaptor.capture());
        assertEquals(veiculoArgumentCaptor.getValue(), veiculoDePasseio);
    }

    @Test
    @DisplayName("Deve atualizar o veiculo com o id com sucesso")
    void testUpdateByIdNotFound() {

        // veiculo
        VeiculoDePasseio veiculoDePasseio = new VeiculoDePasseio();
        veiculoDePasseio.setId(1L);
        veiculoDePasseio.setMarca("Ford");
        veiculoDePasseio.setNome("Focus");
        veiculoDePasseio.setPlaca("ABC-1234");
        veiculoDePasseio.setNumeroDePassageiros(5);

        when(veiculoDePasseioRepository.findById(veiculoDePasseio.getId())).thenReturn(Optional.empty());

        // quando
        assertThrows(NaoEncontradoException.class, () -> veiculoDePasseioService.updateById(veiculoDePasseio));

        // então
        verify(veiculoDePasseioRepository, never()).save(veiculoDePasseio);
    }
}
