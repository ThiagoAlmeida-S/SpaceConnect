package com.SpaceConnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_RESERVATORIO")
public class Reservatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private double capacidadeMaxima;
    private double nivelAtual;
    private double nivelCritico;
    private double percentualAtual;
    private String unidade;
}