package com.SpaceConnect.controller;

import com.SpaceConnect.dto.ReservatorioDTO;
import com.SpaceConnect.model.Reservatorio;
import com.SpaceConnect.service.ReservatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservatorios")
@RequiredArgsConstructor
public class ReservatorioController {

    private final ReservatorioService reservatorioService;

    @GetMapping
    public ResponseEntity<List<Reservatorio>> listarTodos() {
        return ResponseEntity.ok(reservatorioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservatorio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reservatorioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Reservatorio> criar(@RequestBody ReservatorioDTO dto) {
        return ResponseEntity.status(201).body(reservatorioService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservatorio> atualizar(@PathVariable Long id, @RequestBody ReservatorioDTO dto) {
        return ResponseEntity.ok(reservatorioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reservatorioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}