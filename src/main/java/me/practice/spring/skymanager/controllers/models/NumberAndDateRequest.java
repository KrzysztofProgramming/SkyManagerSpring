package me.practice.spring.skymanager.controllers.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class NumberAndDateRequest extends DateRequest{
    @NotNull
    @PositiveOrZero
    private Long flightNumber;
}
