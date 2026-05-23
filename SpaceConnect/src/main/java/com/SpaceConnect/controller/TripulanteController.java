package com.SpaceConnect.controller;

import com.SpaceConnect.dto.TripulanteDTO;
import com.SpaceConnect.model.Tripulante;
import com.SpaceConnect.service.TripulanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tripulantes")
@RequiredArgsConstructor
public class TripulanteController {

    private final TripulanteService tripulanteService;

    @GetMapping
    public ResponseEntity<List<Tripulante>> listarTodos() {
        return ResponseEntity.ok(tripulanteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tripulante> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tripulanteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Tripulante> criar(@RequestBody TripulanteDTO dto) {
        return ResponseEntity.status(201).body(tripulanteService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tripulante> atualizar(@PathVariable Long id, @RequestBody TripulanteDTO dto) {
        return ResponseEntity.ok(tripulanteService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tripulanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
