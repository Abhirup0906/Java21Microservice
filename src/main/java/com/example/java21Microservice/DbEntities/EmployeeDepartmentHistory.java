package com.example.java21Microservice.DbEntities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "EmployeeDepartmentHistory", schema = "HumanResources")
@IdClass(EmployeeDepartmentHistoryId.class)
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class EmployeeDepartmentHistory implements Serializable {

    @Id
    @Column(name = "BusinessEntityID")
    int employeeId;

    @Id
    @Column(name = "DepartmentID")
    int departmentId;

    @Id
    @Column(name = "ShiftID")
    short shiftId;

    @Id
    @Column(name = "StartDate")
    Date startDate;

    @Null
    @Column(name = "EndDate")
    Date endDate;
}

