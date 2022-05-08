package me.practice.spring.skymanager.repositories;

import me.practice.spring.skymanager.models.FlightLoad;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface LoadRepository extends JpaRepository<FlightLoad, Long> {
}
