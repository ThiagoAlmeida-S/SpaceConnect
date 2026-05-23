package com.SpaceConnect.service;

import com.SpaceConnect.dto.ConsumoEnergiaDTO;
import com.SpaceConnect.model.ConsumoEnergia;
import com.SpaceConnect.repository.ConsumoEnergiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumoEnergiaService {

    private final ConsumoEnergiaRepository consumoEnergiaRepository;

    public List<ConsumoEnergia> listarTodos() {
        return consumoEnergiaRepository.findAll();
    }

    public ConsumoEnergia buscarPorId(Long id) {
        return consumoEnergiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo de energia não encontrado"));
    }

    public ConsumoEnergia criar(ConsumoEnergiaDTO dto) {
        ConsumoEnergia consumo = new ConsumoEnergia();
        consumo.setNomeSetor(dto.getNomeSetor());
        consumo.setConsumoKwh(dto.getConsumoKwh());
        consumo.setDataRegistro(dto.getDataRegistro());
        consumo.setFonte(dto.getFonte());
        return consumoEnergiaRepository.save(consumo);
    }

    public ConsumoEnergia atualizar(Long id, ConsumoEnergiaDTO dto) {
        ConsumoEnergia consumo = buscarPorId(id);
        consumo.setNomeSetor(dto.getNomeSetor());
        consumo.setConsumoKwh(dto.getConsumoKwh());
        consumo.setDataRegistro(dto.getDataRegistro());
        consumo.setFonte(dto.getFonte());
        return consumoEnergiaRepository.save(consumo);
    }

    public void deletar(Long id) {
        consumoEnergiaRepository.deleteById(id);
    }
}
