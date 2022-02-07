package com.autoapi.lib;

import com.autoapi.model.Auto;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ColorValidator implements ConstraintValidator<ValidColor, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field != null && Arrays.stream(Auto.Color.values())
                .anyMatch(c -> c.name().equals(field.toUpperCase()));
    }
}
