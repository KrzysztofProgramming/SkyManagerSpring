package me.practice.spring.skymanager.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

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
    private String departureIATACode;
    private String arrivalIATACode;
    private Date departureDate;
}
