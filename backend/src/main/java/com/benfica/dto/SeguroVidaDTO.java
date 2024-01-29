package com.benfica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroVidaDTO {

    private Long valorCobertura;
    private boolean assistenciaFuneral;
    private boolean coberturaConjugeFilhos;
}
