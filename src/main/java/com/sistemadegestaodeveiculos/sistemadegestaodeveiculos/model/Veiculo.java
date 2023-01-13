package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_de_veiculo")
@Entity
@ApiModel(subTypes = {VeiculoDeCarga.class,VeiculoDePasseio.class})
public abstract class Veiculo {

    @ApiModelProperty(notes = "identificador unico dos veiculos no banco de dados")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "identificador do veiculo")
    @Column(unique = true)
    @NotEmpty(message = "A placa não pode esta vazio")
    private String placa;

    @ApiModelProperty(notes = "modelo do veiculo")
    @NotEmpty(message = "O nome não pode esta vazio")
    private String nome;

    @ApiModelProperty(notes = "marca do veiculo")
    @NotEmpty(message = "A marca não pode esta vazio")
    private String marca;
}
