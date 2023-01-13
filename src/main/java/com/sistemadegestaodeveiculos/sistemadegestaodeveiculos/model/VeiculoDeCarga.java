package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "carga")
@ApiModel(description = "Algumas informações dos veiculos de carga")
public class VeiculoDeCarga extends Veiculo {

    @ApiModelProperty(notes = "Quantidade de peso que o veiculo suporta")
    @NotNull(message = "A capacidade não pode ser nulo")
    private Integer capacidade;

    @ApiModelProperty(notes = "Quantidade de carrocerias que o veiculo suporta")
    @Column(name = "quantidade_de_carrocerias")
    @NotNull(message = "A quantidade de carrocerias não pode ser nulo")
    private Integer quantidadeDeCarrocerias;
}
