package me.practice.spring.skymanager.weight;

import lombok.Getter;

public enum WeightUnits {
    KG("kg"),
    LB("lb");

    @Getter
    private final String prefix;

    WeightUnits(String prefix){
        this.prefix = prefix;
    }

}
