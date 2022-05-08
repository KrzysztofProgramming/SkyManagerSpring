package me.practice.spring.skymanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import me.practice.spring.skymanager.controllers.models.LoadModel;
import me.practice.spring.skymanager.weight.WeightUnits;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class FlightLoad {
    @EmbeddedId
    private LoadIdentifier id;

    @Column(name = "weight")
    private Double weightKg;
    private Integer pieces;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("flightId")
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Double getWeightLb(){
        return this.weightKg * 2.20462262;
    }

    public FlightLoad(LoadModel model, Long flightId){
        this.weightKg = model.getWeightUnit().equals(WeightUnits.LB.getPrefix())
                ? model.getWeight() * 0.45359237 : model.getWeight();
        this.pieces = model.getPieces();
        this.id = new LoadIdentifier(model.getId(), flightId);
        this.flight = Flight.builder().flightId(flightId).build();
    }
}
