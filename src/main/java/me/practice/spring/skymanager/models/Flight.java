package me.practice.spring.skymanager.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Flight {
    @Id
    @EqualsAndHashCode.Include
    private Long flightId;
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
}
