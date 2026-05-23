package com.SpaceConnect.dto;

import com.SpaceConnect.model.CargaTripulante;
import com.SpaceConnect.model.StatusSaude;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TripulanteDTO {
    private String nome;
    private LocalDate dataEntrada;
    private CargaTripulante cargo;
    private StatusSaude statusSaude;
}
