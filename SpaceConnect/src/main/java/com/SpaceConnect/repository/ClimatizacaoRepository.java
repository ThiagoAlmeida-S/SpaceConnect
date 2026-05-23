package com.SpaceConnect.repository;

import com.SpaceConnect.model.Climatizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimatizacaoRepository extends JpaRepository<Climatizacao, Long> {
}