package com.SpaceConnect.controller;

import com.SpaceConnect.dto.SensorDTO;
import com.SpaceConnect.model.Sensor;
import com.SpaceConnect.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<Sensor>> listarTodos() {
        return ResponseEntity.ok(sensorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Sensor> criar(@RequestBody SensorDTO dto) {
        return ResponseEntity.status(201).body(sensorService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> atualizar(@PathVariable Long id, @RequestBody SensorDTO dto) {
        return ResponseEntity.ok(sensorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sensorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/simular/{id}")
    public ResponseEntity<Sensor> simular(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.simular(id));
    }
}
