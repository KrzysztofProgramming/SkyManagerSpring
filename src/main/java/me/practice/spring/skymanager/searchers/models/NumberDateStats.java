package me.practice.spring.skymanager.searchers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberDateStats {
    private Double baggageWeight;
    private Double cargoWeight;
    private Double totalWeight;

    public NumberDateStats(Object object){
        Object[] result = (Object[]) object;
        baggageWeight = (Double)result[0];
        cargoWeight = (Double)result[1];
        totalWeight = cargoWeight + baggageWeight;
    }
}
