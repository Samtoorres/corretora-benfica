package com.benfica.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benfica.BenficaApiApplication;
import com.benfica.dto.SeguroImovelDTO;
import com.benfica.model.Imovel;
import com.benfica.model.Seguro;
import com.benfica.repository.ImovelRepository;
import com.benfica.repository.SeguroRepository;
import com.benfica.service.ImovelService;

@Service
public class ImovelServiceImpl implements ImovelService {

	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private SeguroRepository seguroRepository;
	
	static Logger log = Logger.getLogger(BenficaApiApplication.class);
	
	@Override
	public String cadastrar(SeguroImovelDTO seguroImovelDTO, Long idSeguro) {
		
		Seguro seguro = seguroRepository.findById(idSeguro).orElse(null);
		
		try {	
			Imovel imovel = new Imovel();
			imovel.setAreaTerreno(seguroImovelDTO.getAreaTerreno());
			imovel.setInscricao(seguroImovelDTO.getInscricao());
			imovel.setValorImovel(seguroImovelDTO.getValorImovel());
			
			imovel.setSeguro(seguro);
			
			imovelRepository.save(imovel);
			
		} catch(Exception e) {
			log.error(e);
			return "Falha ao cadastrar o seguro do imóvel do cliente";
		}
		
		return "Sucesso ao cadastrar seguro do imóvel do Cliente";
		
	}

}
