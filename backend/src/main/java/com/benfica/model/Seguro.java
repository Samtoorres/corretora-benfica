package com.benfica.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seguro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String vigencia;
	
	@Column
	private Long valor;
	
	@OneToOne
	private TipoSeguro tipoSeguro;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@Column
	private boolean ativo;
}
