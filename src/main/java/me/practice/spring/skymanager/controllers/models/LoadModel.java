package me.practice.spring.skymanager.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.practice.spring.skymanager.weight.WeightUnit;
import me.practice.spring.skymanager.weight.WeightUnits;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoadModel {
    @EqualsAndHashCode.Include
    @NotNull
    private Long id;
    @NotNull
    private Double weight;
    @WeightUnit
    private String weightUnit;
    @PositiveOrZero
    private Integer pieces;
}
