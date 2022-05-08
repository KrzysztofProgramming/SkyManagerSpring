package me.practice.spring.skymanager.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FlightLoad {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private Double weight;
    private Integer pieces;
}
