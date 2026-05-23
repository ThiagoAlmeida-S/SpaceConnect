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
        Sensor original = buscarPorId(id);

        Sensor novaLeitura = new Sensor();
        novaLeitura.setNome(original.getNome());
        novaLeitura.setTipo(original.getTipo());
        novaLeitura.setLocalizacao(original.getLocalizacao());
        novaLeitura.setAtivo(original.isAtivo());
        novaLeitura.setLimiteMinimo(original.getLimiteMinimo());
        novaLeitura.setLimiteMaximo(original.getLimiteMaximo());

        double amplitude = original.getLimiteMaximo() - original.getLimiteMinimo();
        double valor = original.getLimiteMinimo() + (new Random().nextDouble() * amplitude * 1.2) - (amplitude * 0.1);
        valor = Math.round(valor * 10.0) / 10.0;

        novaLeitura.setUltimaLeitura(valor);
        novaLeitura.setDataLeitura(LocalDateTime.now());

        double zona = amplitude * 0.1;
        if (valor < original.getLimiteMinimo() || valor > original.getLimiteMaximo()) {
            novaLeitura.setStatus(StatusSensor.DEFEITO);
        } else if (valor <= original.getLimiteMinimo() + zona || valor >= original.getLimiteMaximo() - zona) {
            novaLeitura.setStatus(StatusSensor.MANUTENCAO);
        } else {
            novaLeitura.setStatus(StatusSensor.OPERACIONAL);
        }

        return sensorRepository.save(novaLeitura);
    }
}