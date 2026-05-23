package com.SpaceConnect.service;

import com.SpaceConnect.dto.SensorDTO;
import com.SpaceConnect.model.Sensor;
import com.SpaceConnect.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Sensor buscarPorId(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));
    }

    public Sensor criar(SensorDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setNome(dto.getNome());
        sensor.setTipo(dto.getTipo());
        sensor.setLocalizacao(dto.getLocalizacao());
        sensor.setAtivo(dto.isAtivo());
        sensor.setUltimaLeitura(dto.getUltimaLeitura());
        sensor.setDataLeitura(dto.getDataLeitura());
        sensor.setStatus(dto.getStatus());
        return sensorRepository.save(sensor);
    }

    public Sensor atualizar(Long id, SensorDTO dto) {
        Sensor sensor = buscarPorId(id);
        sensor.setNome(dto.getNome());
        sensor.setTipo(dto.getTipo());
        sensor.setLocalizacao(dto.getLocalizacao());
        sensor.setAtivo(dto.isAtivo());
        sensor.setUltimaLeitura(dto.getUltimaLeitura());
        sensor.setDataLeitura(dto.getDataLeitura());
        sensor.setStatus(dto.getStatus());
        return sensorRepository.save(sensor);
    }

    public void deletar(Long id) {
        sensorRepository.deleteById(id);
    }
}
