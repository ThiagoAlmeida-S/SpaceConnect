package com.SpaceConnect.service;

import com.SpaceConnect.dto.ClimatizacaoDTO;
import com.SpaceConnect.model.Climatizacao;
import com.SpaceConnect.repository.ClimatizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return climatizacaoRepository.save(climatizacao);
    }

    public void deletar(Long id) {
        climatizacaoRepository.deleteById(id);
    }
}
