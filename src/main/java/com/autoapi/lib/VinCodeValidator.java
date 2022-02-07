package com.autoapi.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VinCodeValidator implements ConstraintValidator<ValidVinCode, String> {
    private static final String VIN_CODE_VALIDATION_REGEX = "[A-HJ-NPR-Z0-9]{17}";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(VIN_CODE_VALIDATION_REGEX);
    }
}
