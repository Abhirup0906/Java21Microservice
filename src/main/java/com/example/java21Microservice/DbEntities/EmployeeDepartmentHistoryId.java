package com.example.java21Microservice.DbEntities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartmentHistoryId implements Serializable {
    int employeeId;
    int departmentId;
    short shiftId;
    Date startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDepartmentHistoryId that = (EmployeeDepartmentHistoryId) o;
        return employeeId == that.employeeId && departmentId == that.departmentId && shiftId == that.shiftId && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, departmentId, shiftId, startDate);
    }
}
