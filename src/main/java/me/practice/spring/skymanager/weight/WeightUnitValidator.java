package me.practice.spring.skymanager.weight;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WeightUnitValidator implements ConstraintValidator<WeightUnit, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            WeightUnits.valueOf(value);
            return true;
        }
        catch (IllegalArgumentException | NullPointerException e){
            return false;
        }
    }
}
