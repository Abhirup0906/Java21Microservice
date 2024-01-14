package com.example.java21Microservice.Request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class GetEmployeeDetails {
    Integer employeeId;
}
