package com.SpaceConnect.dto;

import com.SpaceConnect.model.FonteEnergia;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsumoEnergiaDTO {
    private String nomeSetor;
    private double consumoKwh;
    private LocalDateTime dataRegistro;
    private FonteEnergia fonte;
}