package com.example.java21Microservice.DbEntities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayHistoryId implements Serializable {
    int employeeId;
    Date rateChangeDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayHistoryId that = (EmployeePayHistoryId) o;
        return employeeId == that.employeeId && Objects.equals(rateChangeDate, that.rateChangeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, rateChangeDate);
    }
}
