package com.benfica.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String placa;
	
	@Column
	private String chassi;
	
	@Column
	private String modelo;
	
	@Column
	private String ano;
	
	@Column
	private Long valorVeiculo;
	
	@Column
	private boolean idadeMenorVinteUmDias;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Seguro seguro;
}
