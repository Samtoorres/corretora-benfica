package com.benfica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroVeiculoDTO {

	private String placa;
	private String chassi;
	private String modelo;
	private String ano;
	private Long valorVeiculo;
	private boolean idadeMenorVinteUmDias;
}
