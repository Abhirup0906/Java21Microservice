package com.example.java21Microservice.DbEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "Shift", schema = "HumanResources")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Shift implements Serializable {
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
