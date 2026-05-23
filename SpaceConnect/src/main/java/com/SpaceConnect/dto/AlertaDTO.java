package com.SpaceConnect.dto;

import com.SpaceConnect.model.NivelAlerta;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlertaDTO {
    private String titulo;
    private String descricao;
    private String recursoAfetado;
    private String resolvidoPor;
    private boolean resolvido;
    private LocalDateTime dataHora;
    private NivelAlerta nivel;
}
