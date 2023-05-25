package com.benfica.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benfica.BenficaApiApplication;
import com.benfica.dto.SeguroVeiculoDTO;
import com.benfica.model.Seguro;
import com.benfica.model.Veiculo;
import com.benfica.repository.SeguroRepository;
import com.benfica.repository.VeiculoRepository;
import com.benfica.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private SeguroRepository seguroRepository;
	
	static Logger log = Logger.getLogger(BenficaApiApplication.class);
	
	@Override
	public String cadastrar(SeguroVeiculoDTO seguroVeiculoDTO, Long idSeguro) {
		
		Seguro seguro = seguroRepository.findById(idSeguro).orElse(null);
		
		try {	
			Veiculo veiculo = new Veiculo();
			veiculo.setAno(seguroVeiculoDTO.getAno());
			veiculo.setChassi(seguroVeiculoDTO.getChassi());
			veiculo.setIdadeMenorVinteUmDias(seguroVeiculoDTO.isIdadeMenorVinteUm());
			veiculo.setModelo(seguroVeiculoDTO.getModelo());
			veiculo.setPlaca(seguroVeiculoDTO.getPlaca());
			veiculo.setValorVeiculo(seguroVeiculoDTO.getValorVeiculo());
			veiculo.setSeguro(seguro);
			
			veiculoRepository.save(veiculo);
			
		} catch(Exception e) {
			log.error(e);
			return "Falha ao cadastrar o seguro do veículo do cliente";
		}
		
		return "Sucesso ao cadastrar seguro do veículo do Cliente";
		
	}

}
