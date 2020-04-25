package com.ryd.golfstats.golfstats.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RoundValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Round.class.equals(clazz);
    }

    @Override
    public void validate(Object objectToValidate, Errors errors) {

        //todo - implement buisness logic
    }
}
