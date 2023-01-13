package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO para requisições para a API com algumas informações dos veiculos de carga")
public class VeiculoDeCargaRequest {

    @ApiModelProperty(notes = "identificador unico dos veiculos no banco de dados")
    private Long id;

    @ApiModelProperty(notes = "identificador do veiculo")
    @NotEmpty(message = "A placa não pode esta vazio")
    private String placa;

    @ApiModelProperty(notes = "modelo do veiculo")
    @NotEmpty(message = "O nome não pode esta vazio")
    private String nome;

    @ApiModelProperty(notes = "marca do veiculo")
    @NotEmpty(message = "A marca não pode esta vazio")
    private String marca;
    
    @ApiModelProperty(notes = "Quantidade de peso que o veiculo suporta")
    @NotNull(message = "A capacidade não pode ser nulo")
    private Integer capacidade;

    @ApiModelProperty(notes = "Quantidade de carrocerias que o veiculo suporta")
    @NotNull(message = "A quantidade de carrocerias não pode ser nulo")
    private Integer quantidadeDeCarrocerias;
}
