package com.SpaceConnect.controller;

import com.SpaceConnect.dto.ConsumoEnergiaDTO;
import com.SpaceConnect.model.ConsumoEnergia;
import com.SpaceConnect.service.ConsumoEnergiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo-energia")
@RequiredArgsConstructor
public class ConsumoEnergiaController {

    private final ConsumoEnergiaService consumoEnergiaService;

    @GetMapping
    public ResponseEntity<List<ConsumoEnergia>> listarTodos() {
        return ResponseEntity.ok(consumoEnergiaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(consumoEnergiaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ConsumoEnergia> criar(@RequestBody ConsumoEnergiaDTO dto) {
        return ResponseEntity.status(201).body(consumoEnergiaService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> atualizar(@PathVariable Long id, @RequestBody ConsumoEnergiaDTO dto) {
        return ResponseEntity.ok(consumoEnergiaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consumoEnergiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}