package com.example.java21Microservice.DbEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.sql.Date;

@Entity()
@Table(name = "Department", schema = "HumanResources")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    int departmentId;

    @Column(name = "Name")
    String departmentName;

    @Column(name = "GroupName")
    String groupName;

    @Column(name = "ModifiedDate")
    Date modifiedDate;
}
