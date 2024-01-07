package com.example.java21Microservice.DbEntities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "Person", schema = "Person")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Person implements Serializable {

    @Id
    @Column(name = "BusinessEntityID")
    int personId;

    @Column(name = "PersonType")
    String personType;

    @Null
    @Column(name = "Title")
    String title;

    @Column(name = "FirstName")
    String firstName;

    @Null
    @Column(name = "MiddleName")
    String middleName;

    @Column(name = "LastName")
    String lastName;

    @Null
    @Column(name = "Suffix")
    String suffix;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    Employee employee;
}
