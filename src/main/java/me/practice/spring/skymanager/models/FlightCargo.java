package me.practice.spring.skymanager.models;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = FlightCargo.TABLE_NAME)
public class FlightCargo extends FlightLoad {
    public static final String TABLE_NAME = "cargo_table";

    @Builder
    public FlightCargo(Long id, Double weight, Integer pieces) {
        super(id, weight, pieces);
    }
}
