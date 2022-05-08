package me.practice.spring.skymanager.models;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = FlightBaggage.TABLE_NAME)
public class FlightBaggage extends FlightLoad {
    public static final String TABLE_NAME = "baggage_table";

    @Builder
    public FlightBaggage(Long id, Double weight, Integer pieces, Long flightId, Flight flight) {
        super(id, weight, pieces, flightId, flight);
    }
}
