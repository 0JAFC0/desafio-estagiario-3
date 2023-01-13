package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDePasseio;

public interface VeiculoDePasseioRepository extends JpaRepository<VeiculoDePasseio, Long> {
    
    public Optional<List<VeiculoDePasseio>> findByNome(String nomeDoVeiculo);

    public Optional<VeiculoDePasseio> findByPlaca(String placa);

    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM Veiculo v WHERE v.placa = :placa")
    boolean existsByPlaca(@Param("placa") String placa);
}
