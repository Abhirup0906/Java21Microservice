package com.example.java21Microservice.DbEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

@Entity
@Table(name = "Employee", schema = "HumanResources")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusinessEntityID")
    int employeeId;

    @Column(name = "NationalIDNumber")
    String idNumber;

    @Column(name = "LoginID")
    String LoginId;

    @Column(name = "JobTitle")
    String jobTitle;

    @Column(name =  "BirthDate")
    Date birthDate;

    @Column(name = "MaritalStatus")
    char maritalStatus;

    @Column(name = "Gender")
    char gender;

    @Column(name = "HireDate")
    Date hireDate;

    @Column(name = "SalariedFlag")
    boolean salaried;

    @Column(name = "VacationHours")
    short vacationHours;

    @Column(name = "SickLeaveHours")
    short sickLeave;

    @Column(name = "CurrentFlag")
    boolean current;
}
