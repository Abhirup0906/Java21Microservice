package com.example.java21Microservice.AR;

import br.com.fluentvalidator.Validator;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseAr<T, U> implements BaseAr<T, U>{

    @Autowired
    Validator<T> validator;

    @Override
    public boolean validate(T request) {
        return validator.validate(request).isValid();
    }

    @Override
    public U handler(T request) {
        if (validate(request)) {
            return handle(request);
        }
        else throw new ValidationException("Data validation has been failed");
    }

    protected abstract U handle(T request);
}
