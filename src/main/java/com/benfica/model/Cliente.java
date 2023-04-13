package com.benfica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NonNull
	private String nome;
	
	@Column
	private String cpf;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<ContatoCliente> contatoCliente;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Seguro seguro;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Endereco endereco;
}
