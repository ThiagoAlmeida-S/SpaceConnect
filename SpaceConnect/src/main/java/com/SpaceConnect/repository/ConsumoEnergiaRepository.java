package com.SpaceConnect.repository;

import com.SpaceConnect.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoEnergiaRepository extends JpaRepository<ConsumoEnergia, Long> {
}
