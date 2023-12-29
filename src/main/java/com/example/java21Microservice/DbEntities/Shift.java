package com.example.java21Microservice.DbEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Time;

@Entity
@Table(name = "Shift", schema = "HumanResources")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Shift {

    @Id
    @Column(name = "ShiftID")
    short shiftId;

    @Column(name = "Name")
    String shiftName;

    @Column(name = "StartTime")
    Time startTime;

    @Column(name = "EndTime")
    Time endTime;
}
