package com.SpaceConnect.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CONSUMO_ENERGIA")
public class ConsumoEnergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSetor;
    private double consumoKwh;
    private LocalDateTime dataRegistro;

    @Enumerated(EnumType.STRING)
    private FonteEnergia fonte;
}
