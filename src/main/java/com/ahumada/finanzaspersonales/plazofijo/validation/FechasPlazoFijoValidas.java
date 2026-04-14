package com.ahumada.finanzaspersonales.plazofijo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = FechasPlazoFijoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FechasPlazoFijoValidas {

    String message() default "La fecha de vencimiento debe ser mayor o igual a la fecha de constitución";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
