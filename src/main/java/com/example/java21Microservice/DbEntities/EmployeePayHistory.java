package com.example.java21Microservice.DbEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

@Entity
@Table(name = "EmployeePayHistory", schema = "HumanResources")
@IdClass(EmployeePayHistoryId.class)
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class EmployeePayHistory {

    @Id
    @Column(name = "BusinessEntityID")
    int employeeId;

    @Id
    @Column(name = "RateChangeDate")
    Date rateChangeDate;

    @Column(name = "Rate")
    float rate;

    @Column(name = "PayFrequency")
    short payFrequency;
}

