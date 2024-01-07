package com.example.java21Microservice.DbEntities;


import com.example.java21Microservice.ResponseModel.EmployeeDepartment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "Department", schema = "HumanResources")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Department implements Serializable {

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

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    Set<EmployeeDepartmentHistory> EmployeeDepartmentHistory;
}
