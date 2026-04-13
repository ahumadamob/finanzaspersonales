package com.ahumada.finanzaspersonales.plazofijo.validation;

import com.ahumada.finanzaspersonales.plazofijo.PlazoFijo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FechasPlazoFijoValidator implements ConstraintValidator<FechasPlazoFijoValidas, PlazoFijo> {

    @Override
    public boolean isValid(PlazoFijo value, ConstraintValidatorContext context) {
        if (value == null || value.getFechaConstitucion() == null || value.getFechaVencimiento() == null) {
            return true;
        }

        return !value.getFechaVencimiento().isBefore(value.getFechaConstitucion());
    }
}
