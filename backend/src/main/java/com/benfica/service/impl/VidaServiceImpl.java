package com.benfica.service.impl;

import com.benfica.dto.SeguroVidaDTO;
import com.benfica.model.Seguro;
import com.benfica.model.Vida;
import com.benfica.repository.SeguroRepository;
import com.benfica.repository.VidaRepository;
import com.benfica.service.VidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VidaServiceImpl implements VidaService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Autowired
    private VidaRepository vidaRepository;

    @Override
    public String cadastrar(SeguroVidaDTO seguroVidaDTO, Long idSeguro) {

        Seguro seguro = seguroRepository.findById(idSeguro).orElse(null);
        Vida vida = new Vida();

        vida.setSeguro(seguro);
        vida.setAssistenciaFuneral(seguroVidaDTO.isAssistenciaFuneral());
        vida.setCoberturaConjugeFilhos(seguroVidaDTO.isCoberturaConjugeFilhos());
        vida.setValorCobertura(seguroVidaDTO.getValorCobertura());

        vidaRepository.save(vida);

        return "Cliente Cadastrado com sucesso";
    }
}
