package com.SpaceConnect.service;

import com.SpaceConnect.dto.SensorDTO;
import com.SpaceConnect.model.Sensor;
import com.SpaceConnect.model.StatusSensor;
import com.SpaceConnect.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
        sensor.setLimiteMinimo(dto.getLimiteMinimo());
        sensor.setLimiteMaximo(dto.getLimiteMaximo());
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
        sensor.setLimiteMinimo(dto.getLimiteMinimo());
        sensor.setLimiteMaximo(dto.getLimiteMaximo());
        return sensorRepository.save(sensor);
    }

    public void deletar(Long id) {
        sensorRepository.deleteById(id);
    }

    public Sensor simular(Long id) {
        Sensor sensor = buscarPorId(id);
        double amplitude = sensor.getLimiteMaximo() - sensor.getLimiteMinimo();
        double valor = sensor.getLimiteMinimo() + (new Random().nextDouble() * amplitude * 1.2) - (amplitude * 0.1);
        valor = Math.round(valor * 10.0) / 10.0;

        sensor.setUltimaLeitura(valor);
        sensor.setDataLeitura(LocalDateTime.now());

        double zona = amplitude * 0.1;
        if (valor < sensor.getLimiteMinimo() || valor > sensor.getLimiteMaximo()) {
            sensor.setStatus(StatusSensor.DEFEITO);
        } else if (valor <= sensor.getLimiteMinimo() + zona || valor >= sensor.getLimiteMaximo() - zona) {
            sensor.setStatus(StatusSensor.MANUTENCAO);
        } else {
            sensor.setStatus(StatusSensor.OPERACIONAL);
        }

        return sensorRepository.save(sensor);
    }
}