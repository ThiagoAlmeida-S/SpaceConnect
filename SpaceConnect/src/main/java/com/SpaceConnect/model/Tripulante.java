package com.SpaceConnect.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_TRIPULANTE")
public class Tripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataEntrada;

    @Enumerated(EnumType.STRING)
    private CargaTripulante cargo;

    @Enumerated(EnumType.STRING)
    private StatusSaude statusSaude;
}
