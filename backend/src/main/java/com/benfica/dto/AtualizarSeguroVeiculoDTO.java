package com.benfica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarSeguroVeiculoDTO {

    private Long id;
    private String vigencia;
    private Long valor;
    private String placa;
    private String chassi;
    private String modelo;
    private String ano;
    private Long valorVeiculo;
    private boolean idadeMenorVinteUmDias;
}
