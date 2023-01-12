package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "passeio")
@ApiModel(description = "Algumas informações dos veiculos de passeio")
public class VeiculoDePasseio extends Veiculo {

    @ApiModelProperty(notes = "quantidade de passageiros que o veiculo comporta")
    @Column(name = "numero_de_passageiros")
    private Integer numeroDePassageiros;
}
