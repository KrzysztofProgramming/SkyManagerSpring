package me.practice.spring.skymanager.models;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.practice.spring.skymanager.controllers.models.LoadModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = FlightCargo.TABLE_NAME)
public class FlightCargo extends FlightLoad {
    public static final String TABLE_NAME = "cargo_table";

    @Builder
    public FlightCargo(LoadIdentifier id, Double weightKg, Integer pieces, Flight flight) {
        super(id, weightKg, pieces, flight);
    }

    public FlightCargo(LoadModel model, Long flightId) {
        super(model, flightId);
    }
}
