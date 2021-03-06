package me.practice.spring.skymanager.repositories;

import me.practice.spring.skymanager.models.FlightCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<FlightCargo, Long> {
}
