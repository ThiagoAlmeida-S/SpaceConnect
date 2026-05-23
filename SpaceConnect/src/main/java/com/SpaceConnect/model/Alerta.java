package com.SpaceConnect.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String recursoAfetado;
    private String resolvidoPor;
    private boolean resolvido;
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private NivelAlerta nivel;
}

