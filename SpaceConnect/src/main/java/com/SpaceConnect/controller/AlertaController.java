package com.SpaceConnect.controller;

import com.SpaceConnect.dto.AlertaDTO;
import com.SpaceConnect.model.Alerta;
import com.SpaceConnect.service.AlertaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService alertaService;

    @GetMapping
    public ResponseEntity<List<Alerta>> listarTodos() {
        return ResponseEntity.ok(alertaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alertaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Alerta> criar(@RequestBody AlertaDTO dto) {
        return ResponseEntity.status(201).body(alertaService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizar(@PathVariable Long id, @RequestBody AlertaDTO dto) {
        return ResponseEntity.ok(alertaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alertaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
