package com.example.java21Microservice.AR;

import br.com.fluentvalidator.Validator;

public interface BaseAr<T, U> {
    boolean validate(T request);
    U handler(T request);
}
