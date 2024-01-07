package com.example.java21Microservice.ResponseModel;

import java.sql.Date;

public record EmployeeDetails (int employeeId, String personType, String firstName, String lastName,
                               char gender, Date hireDate) {
}
