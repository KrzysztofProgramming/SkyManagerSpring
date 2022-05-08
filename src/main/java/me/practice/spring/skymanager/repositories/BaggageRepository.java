package me.practice.spring.skymanager.repositories;

import me.practice.spring.skymanager.models.FlightBaggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<FlightBaggage, Long> {
}
