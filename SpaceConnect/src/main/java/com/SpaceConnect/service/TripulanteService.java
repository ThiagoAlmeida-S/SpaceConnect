package com.SpaceConnect.service;

import com.SpaceConnect.dto.TripulanteDTO;
import com.SpaceConnect.model.Tripulante;
import com.SpaceConnect.repository.TripulanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripulanteService {

    private final TripulanteRepository tripulanteRepository;

    public List<Tripulante> listarTodos() {
        return tripulanteRepository.findAll();
    }

    public Tripulante buscarPorId(Long id) {
        return tripulanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tripulante não encontrado"));
    }

    public Tripulante criar(TripulanteDTO dto) {
        Tripulante tripulante = new Tripulante();
        tripulante.setNome(dto.getNome());
        tripulante.setDataEntrada(dto.getDataEntrada());
        tripulante.setCargo(dto.getCargo());
        tripulante.setStatusSaude(dto.getStatusSaude());
        return tripulanteRepository.save(tripulante);
    }

    public Tripulante atualizar(Long id, TripulanteDTO dto) {
        Tripulante tripulante = buscarPorId(id);
        tripulante.setNome(dto.getNome());
        tripulante.setDataEntrada(dto.getDataEntrada());
        tripulante.setCargo(dto.getCargo());
        tripulante.setStatusSaude(dto.getStatusSaude());
        return tripulanteRepository.save(tripulante);
    }

    public void deletar(Long id) {
        tripulanteRepository.deleteById(id);
    }
}
