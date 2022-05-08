package me.practice.spring.skymanager.models;

import lombok.*;
import me.practice.spring.skymanager.controllers.models.FlightRequest;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "flight_table", indexes = {
        @Index(name = "idx_flight_number", columnList = "flight_number"),
        @Index(name = "idx_arrival_iata", columnList = "arrival_iata_code"),
        @Index(name = "idx_departure_iata", columnList = "departure_iata_code"),
        @Index(name = "idx_departure_date", columnList = "departure_date")
})
public class Flight {
    public static final String TABLE_NAME = "flight_table";
    @Id
    @EqualsAndHashCode.Include
    private Long flightId;
    @Column(name = "flight_number")
    private Long flightNumber;
    @Column(name = "departure_iata_code")
    private String departureIATACode;
    @Column(name = "arrival_iata_code")
    private String arrivalIATACode;
    @Column(name = "departure_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private Set<FlightCargo> cargo;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private Set<FlightBaggage> baggage;

    public Flight(FlightRequest request){
        flightId = request.getFlightId();
        flightNumber = request.getFlightNumber();
        departureIATACode = request.getDepartureAirportIATACode();
        arrivalIATACode = request.getArrivalAirportIATACode();
        departureDate = request.getDepartureDate();
    }
}
