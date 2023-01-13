package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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
    private String placa;

    @ApiModelProperty(notes = "modelo do veiculo")
    private String nome;

    @ApiModelProperty(notes = "marca do veiculo")
    private String marca;
}
