package com.SpaceConnect.repository;

import com.SpaceConnect.model.Reservatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservatorioRepository extends JpaRepository<Reservatorio, Long> {
}
