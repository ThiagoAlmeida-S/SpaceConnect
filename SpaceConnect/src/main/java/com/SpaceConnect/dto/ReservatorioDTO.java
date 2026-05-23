package com.SpaceConnect.dto;

import lombok.Data;

@Data
public class ReservatorioDTO {
    private String nome;
    private String tipo;
    private double capacidadeMaxima;
    private double nivelAtual;
    private double nivelCritico;
    private String unidade;
}
