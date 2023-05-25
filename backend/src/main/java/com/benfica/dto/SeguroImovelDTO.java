package com.benfica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroImovelDTO {

	private String areaTerreno;
	private Long valorImovel;
	private String inscricao;
}
