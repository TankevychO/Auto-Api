package com.autoapi.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidator implements ConstraintValidator<ValidNumber, String> {
    private static final String NUMBER_VALIDATION_REGEX = "[A-Z]{2}\\d{4}[A-Z]{2}";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(NUMBER_VALIDATION_REGEX);
    }
}
