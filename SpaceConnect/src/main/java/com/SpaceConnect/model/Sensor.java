package com.SpaceConnect.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String localizacao;
    private boolean ativo;
    private double ultimaLeitura;
    private LocalDateTime dataLeitura;

    @Enumerated(EnumType.STRING)
    private StatusSensor status;
}