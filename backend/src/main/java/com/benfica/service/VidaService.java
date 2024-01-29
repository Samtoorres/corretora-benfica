package com.benfica.service;

import com.benfica.dto.SeguroVidaDTO;

public interface VidaService {

    public String cadastrar(SeguroVidaDTO seguroVidaDTO, Long idSeguro);
}
