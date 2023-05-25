package com.benfica.dto;

import com.benfica.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO{

	private String nome;
	private String cpf;
	private Long tipoUsuario;
	private Endereco endereco;
}
