package com.SpaceConnect.controller;

import com.SpaceConnect.dto.ClimatizacaoDTO;
import com.SpaceConnect.model.Climatizacao;
import com.SpaceConnect.service.ClimatizacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/climatizacao")
@RequiredArgsConstructor
public class ClimatizacaoController {

    private final ClimatizacaoService climatizacaoService;

    @GetMapping
    public ResponseEntity<List<Climatizacao>> listarTodos() {
        return ResponseEntity.ok(climatizacaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Climatizacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(climatizacaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Climatizacao> criar(@RequestBody ClimatizacaoDTO dto) {
        return ResponseEntity.status(201).body(climatizacaoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Climatizacao> atualizar(@PathVariable Long id, @RequestBody ClimatizacaoDTO dto) {
        return ResponseEntity.ok(climatizacaoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        climatizacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/simular/{id}")
    public ResponseEntity<Climatizacao> simular(@PathVariable Long id) {
        return ResponseEntity.ok(climatizacaoService.simular(id));
    }
}
