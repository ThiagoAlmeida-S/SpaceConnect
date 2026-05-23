package com.SpaceConnect.service;

import com.SpaceConnect.dto.ClimatizacaoDTO;
import com.SpaceConnect.model.Climatizacao;
import com.SpaceConnect.repository.ClimatizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ClimatizacaoService {

    private final ClimatizacaoRepository climatizacaoRepository;

    public List<Climatizacao> listarTodos() {
        return climatizacaoRepository.findAll();
    }

    public Climatizacao buscarPorId(Long id) {
        return climatizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Climatização não encontrada"));
    }

    public Climatizacao criar(ClimatizacaoDTO dto) {
        Climatizacao climatizacao = new Climatizacao();
        climatizacao.setSetor(dto.getSetor());
        climatizacao.setTemperaturaAtual(dto.getTemperaturaAtual());
        climatizacao.setTemperaturaDesejada(dto.getTemperaturaDesejada());
        climatizacao.setUmidade(dto.getUmidade());
        climatizacao.setPressaoAtmosferica(dto.getPressaoAtmosferica());
        climatizacao.setSistemaAtivo(dto.isSistemaAtivo());
        climatizacao.setStatus(calcularStatus(dto.getTemperaturaAtual(), dto.getTemperaturaDesejada()));
        return climatizacaoRepository.save(climatizacao);
    }

    public Climatizacao atualizar(Long id, ClimatizacaoDTO dto) {
        Climatizacao climatizacao = buscarPorId(id);
        climatizacao.setSetor(dto.getSetor());
        climatizacao.setTemperaturaAtual(dto.getTemperaturaAtual());
        climatizacao.setTemperaturaDesejada(dto.getTemperaturaDesejada());
        climatizacao.setUmidade(dto.getUmidade());
        climatizacao.setPressaoAtmosferica(dto.getPressaoAtmosferica());
        climatizacao.setSistemaAtivo(dto.isSistemaAtivo());
        climatizacao.setStatus(calcularStatus(dto.getTemperaturaAtual(), dto.getTemperaturaDesejada()));
        return climatizacaoRepository.save(climatizacao);
    }

    public void deletar(Long id) {
        climatizacaoRepository.deleteById(id);
    }

    public Climatizacao simular(Long id) {
        Climatizacao original = buscarPorId(id);

        Climatizacao novaLeitura = new Climatizacao();
        novaLeitura.setSetor(original.getSetor());
        novaLeitura.setTemperaturaDesejada(original.getTemperaturaDesejada());
        novaLeitura.setUmidade(original.getUmidade());
        novaLeitura.setPressaoAtmosferica(original.getPressaoAtmosferica());
        novaLeitura.setSistemaAtivo(original.isSistemaAtivo());

        double variacao = (new Random().nextDouble() * 10) - 5;
        double novaTemp = original.getTemperaturaAtual() + variacao;
        novaTemp = Math.round(novaTemp * 10.0) / 10.0;

        novaLeitura.setTemperaturaAtual(novaTemp);
        novaLeitura.setStatus(calcularStatus(novaTemp, original.getTemperaturaDesejada()));

        return climatizacaoRepository.save(novaLeitura);
    }

    private String calcularStatus(double temperaturaAtual, double temperaturaDesejada) {
        double diferenca = Math.abs(temperaturaAtual - temperaturaDesejada);
        if (diferenca <= 2) {
            return "NORMAL";
        } else if (diferenca <= 5) {
            return "ALERTA";
        } else {
            return "CRITICO";
        }
    }
}