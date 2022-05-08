package me.practice.spring.skymanager.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoadRequest {
    @EqualsAndHashCode.Include
    @NotNull
    private Long flightId;

    @NotNull
    List<LoadModel> cargo;
    @NotNull
    List<LoadModel> baggage;
}
