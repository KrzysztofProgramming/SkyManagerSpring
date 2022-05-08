package me.practice.spring.skymanager.models;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.practice.spring.skymanager.controllers.models.LoadModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = FlightBaggage.TABLE_NAME)
public class FlightBaggage extends FlightLoad {
    public static final String TABLE_NAME = "baggage_table";

    @Builder
    public FlightBaggage(LoadIdentifier id, Double weightKg, Integer pieces, Flight flight) {
        super(id, weightKg, pieces, flight);
    }

    public FlightBaggage(LoadModel model, Long flightId) {
        super(model, flightId);
    }
}
