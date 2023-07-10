package com.benfica.service.impl;

import com.benfica.dto.AtualizarSeguroVeiculoDTO;
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

		Veiculo veiculo = new Veiculo();
		veiculo.setAno(seguroVeiculoDTO.getAno());
		veiculo.setChassi(seguroVeiculoDTO.getChassi());
		veiculo.setIdadeMenorVinteUmDias(seguroVeiculoDTO.isIdadeMenorVinteUm());
		veiculo.setModelo(seguroVeiculoDTO.getModelo());
		veiculo.setPlaca(seguroVeiculoDTO.getPlaca());
		veiculo.setValorVeiculo(seguroVeiculoDTO.getValorVeiculo());
		veiculo.setSeguro(seguro);

		veiculoRepository.save(veiculo);

		return "Sucesso ao cadastrar seguro do veículo do Cliente";
	}

	@Override
	public String atualizar(AtualizarSeguroVeiculoDTO atualizarSeguroVeiculoDTO) {

		Veiculo veiculo = veiculoRepository.findById(atualizarSeguroVeiculoDTO.getId()).orElse(null);
		Seguro seguro = seguroRepository.findById(veiculo.getSeguro().getId()).orElse(null);

		seguro.setValor(atualizarSeguroVeiculoDTO.getValor());
		seguro.setVigencia(atualizarSeguroVeiculoDTO.getVigencia());
		seguroRepository.save(seguro);

		veiculo.setAno(atualizarSeguroVeiculoDTO.getAno());
		veiculo.setValorVeiculo(atualizarSeguroVeiculoDTO.getValorVeiculo());
		veiculo.setModelo(atualizarSeguroVeiculoDTO.getModelo());
		veiculo.setChassi(atualizarSeguroVeiculoDTO.getChassi());
		veiculo.setIdadeMenorVinteUmDias(atualizarSeguroVeiculoDTO.isIdadeMenorVinteUmDias());
		veiculo.setSeguro(seguro);

		return "Sucesso ao atualizar os dados do seguro";
	}

}
