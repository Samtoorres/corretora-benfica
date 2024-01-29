package com.benfica.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Vida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long valorCobertura;

    @Column
    private boolean assistenciaFuneral;

    @Column
    private boolean coberturaConjugeFilhos;

    @OneToOne(cascade = CascadeType.ALL)
    private Seguro seguro;
}
