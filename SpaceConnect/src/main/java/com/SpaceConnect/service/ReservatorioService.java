package com.SpaceConnect.service;

import com.SpaceConnect.dto.ReservatorioDTO;
import com.SpaceConnect.model.Reservatorio;
import com.SpaceConnect.repository.ReservatorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        reservatorio.setStatus(calcularStatus(dto.getNivelAtual(), dto.getNivelCritico(), dto.getCapacidadeMaxima()));
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
        reservatorio.setStatus(calcularStatus(dto.getNivelAtual(), dto.getNivelCritico(), dto.getCapacidadeMaxima()));
        return reservatorioRepository.save(reservatorio);
    }

    public void deletar(Long id) {
        reservatorioRepository.deleteById(id);
    }

    public Reservatorio simular(Long id) {
        Reservatorio reservatorio = buscarPorId(id);
        double variacao = (new Random().nextDouble() * 20) - 10;
        double novoNivel = reservatorio.getNivelAtual() + variacao;
        novoNivel = Math.max(0, Math.min(novoNivel, reservatorio.getCapacidadeMaxima()));
        novoNivel = Math.round(novoNivel * 10.0) / 10.0;

        reservatorio.setNivelAtual(novoNivel);
        reservatorio.setPercentualAtual(novoNivel / reservatorio.getCapacidadeMaxima() * 100);
        reservatorio.setStatus(calcularStatus(novoNivel, reservatorio.getNivelCritico(), reservatorio.getCapacidadeMaxima()));

        return reservatorioRepository.save(reservatorio);
    }

    private String calcularStatus(double nivelAtual, double nivelCritico, double capacidadeMaxima) {
        double zonaAlerta = nivelCritico * 1.2;
        if (nivelAtual <= nivelCritico) {
            return "CRITICO";
        } else if (nivelAtual <= zonaAlerta) {
            return "ALERTA";
        } else {
            return "NORMAL";
        }
    }
}