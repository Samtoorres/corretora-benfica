package com.benfica.dto;

import java.util.List;

import com.benfica.model.ContatoCliente;
import com.benfica.model.Endereco;
import com.benfica.model.Seguro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRetornoCompletoDTO {

	private Long id;
	private String nome;
	private String cpf;
	private List<ContatoCliente> contatoCliente;
	private List<Seguro> seguro;
	private Long tipoSeguro;
	private Endereco endereco;
	private List<Object> objetoSeguro;
}
