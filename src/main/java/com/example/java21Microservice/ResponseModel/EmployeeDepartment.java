package com.example.java21Microservice.ResponseModel;

import java.sql.Date;
import java.util.Optional;

public record EmployeeDepartment(int employeeId, String departmentName, String firstName,
                                 Optional<String> middleName, String lastName, String groupName,
                                 String jobTitle, Date startDate, Optional<String> suffix,
                                 Optional<String> title) {
}
