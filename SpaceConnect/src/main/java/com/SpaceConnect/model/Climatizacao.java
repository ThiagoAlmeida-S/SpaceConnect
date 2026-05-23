package com.SpaceConnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_CLIMATIZACAO")
public class Climatizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String setor;
    private double temperaturaAtual;
    private double temperaturaDesejada;
    private double umidade;
    private double pressaoAtmosferica;
    private boolean sistemaAtivo;
}
