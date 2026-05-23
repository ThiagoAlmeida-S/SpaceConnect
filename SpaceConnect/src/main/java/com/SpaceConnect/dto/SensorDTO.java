package com.SpaceConnect.dto;

import com.SpaceConnect.model.StatusSensor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SensorDTO {
    private String nome;
    private String tipo;
    private String localizacao;
    private boolean ativo;
    private double ultimaLeitura;
    private LocalDateTime dataLeitura;
    private StatusSensor status;
    private double limiteMinimo;
    private double limiteMaximo;
}
