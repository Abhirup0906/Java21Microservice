package com.example.java21Microservice.AR;


public interface BaseAr<T, U> {
    boolean validate(T request);
    U handler(T request);
}
