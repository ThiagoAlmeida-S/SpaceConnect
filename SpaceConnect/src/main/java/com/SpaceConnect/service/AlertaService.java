package com.SpaceConnect.service;

import com.SpaceConnect.dto.AlertaDTO;
import com.SpaceConnect.model.Alerta;
import com.SpaceConnect.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository alertaRepository;

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Alerta buscarPorId(Long id) {
        return alertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
    }

    public Alerta criar(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        alerta.setTitulo(dto.getTitulo());
        alerta.setDescricao(dto.getDescricao());
        alerta.setRecursoAfetado(dto.getRecursoAfetado());
        alerta.setResolvidoPor(dto.getResolvidoPor());
        alerta.setResolvido(dto.isResolvido());
        alerta.setDataHora(dto.getDataHora());
        alerta.setNivel(dto.getNivel());
        return alertaRepository.save(alerta);
    }

    public Alerta atualizar(Long id, AlertaDTO dto) {
        Alerta alerta = buscarPorId(id);
        alerta.setTitulo(dto.getTitulo());
        alerta.setDescricao(dto.getDescricao());
        alerta.setRecursoAfetado(dto.getRecursoAfetado());
        alerta.setResolvidoPor(dto.getResolvidoPor());
        alerta.setResolvido(dto.isResolvido());
        alerta.setDataHora(dto.getDataHora());
        alerta.setNivel(dto.getNivel());
        return alertaRepository.save(alerta);
    }

    public void deletar(Long id) {
        alertaRepository.deleteById(id);
    }
}