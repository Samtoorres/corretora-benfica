package com.benfica.dto;

import com.benfica.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarClienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private Endereco endereco;
//	private String rua;
//	private String lote;
//	private Integer cep;
}
