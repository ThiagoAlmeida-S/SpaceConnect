package com.SpaceConnect.dto;

import lombok.Data;

@Data
public class ClimatizacaoDTO {
    private String setor;
    private double temperaturaAtual;
    private double temperaturaDesejada;
    private double umidade;
    private double pressaoAtmosferica;
    private boolean sistemaAtivo;
}
