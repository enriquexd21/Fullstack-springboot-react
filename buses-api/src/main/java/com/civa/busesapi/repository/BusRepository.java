package com.civa.busesapi.repository;

import com.civa.busesapi.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}