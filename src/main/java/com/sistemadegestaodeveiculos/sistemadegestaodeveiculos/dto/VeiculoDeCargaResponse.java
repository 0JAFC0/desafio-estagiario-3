package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO para response da API com algumas informações dos veiculos de carga")
public class VeiculoDeCargaResponse {
    
    @ApiModelProperty(notes = "identificador unico dos veiculos no banco de dados")
    private Long id;

    @ApiModelProperty(notes = "identificador do veiculo")
    private String placa;

    @ApiModelProperty(notes = "modelo do veiculo")
    private String nome;

    @ApiModelProperty(notes = "marca do veiculo")
    private String marca;
    
    @ApiModelProperty(notes = "Quantidade de peso que o veiculo suporta")
    private Integer capacidade;

    @ApiModelProperty(notes = "Quantidade de carrocerias que o veiculo suporta")
    private Integer quantidadeDeCarrocerias;
}
