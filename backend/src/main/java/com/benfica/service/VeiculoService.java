package com.benfica.service;

import com.benfica.dto.AtualizarSeguroVeiculoDTO;
import com.benfica.dto.SeguroVeiculoDTO;

public interface VeiculoService {

	public String cadastrar(SeguroVeiculoDTO seguroVeiculoDTO, Long idSeguro);
	public String atualizar(AtualizarSeguroVeiculoDTO atualizarSeguroVeiculoDTO);
}
