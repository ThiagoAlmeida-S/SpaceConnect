package com.SpaceConnect.service;

import com.SpaceConnect.dto.ReservatorioDTO;
import com.SpaceConnect.model.Reservatorio;
import com.SpaceConnect.repository.ReservatorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservatorioService {

    private final ReservatorioRepository reservatorioRepository;

    public List<Reservatorio> listarTodos() {
        return reservatorioRepository.findAll();
    }

    public Reservatorio buscarPorId(Long id) {
        return reservatorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservatório não encontrado"));
    }

    public Reservatorio criar(ReservatorioDTO dto) {
        Reservatorio reservatorio = new Reservatorio();
        reservatorio.setNome(dto.getNome());
        reservatorio.setTipo(dto.getTipo());
        reservatorio.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        reservatorio.setNivelAtual(dto.getNivelAtual());
        reservatorio.setNivelCritico(dto.getNivelCritico());
        reservatorio.setUnidade(dto.getUnidade());
        reservatorio.setPercentualAtual(dto.getNivelAtual() / dto.getCapacidadeMaxima() * 100);
        return reservatorioRepository.save(reservatorio);
    }

    public Reservatorio atualizar(Long id, ReservatorioDTO dto) {
        Reservatorio reservatorio = buscarPorId(id);
        reservatorio.setNome(dto.getNome());
        reservatorio.setTipo(dto.getTipo());
        reservatorio.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        reservatorio.setNivelAtual(dto.getNivelAtual());
        reservatorio.setNivelCritico(dto.getNivelCritico());
        reservatorio.setUnidade(dto.getUnidade());
        reservatorio.setPercentualAtual(dto.getNivelAtual() / dto.getCapacidadeMaxima() * 100);
        return reservatorioRepository.save(reservatorio);
    }

    public void deletar(Long id) {
        reservatorioRepository.deleteById(id);
    }
}
