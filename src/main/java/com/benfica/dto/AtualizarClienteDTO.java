package com.benfica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarClienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
}
