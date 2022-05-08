package me.practice.spring.skymanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class FlightLoad {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private Double weight;
    private Integer pieces;

    @Column(name = "flight_id")
    protected Long flightId;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", insertable = false, updatable = false)
    protected Flight flight;
}
