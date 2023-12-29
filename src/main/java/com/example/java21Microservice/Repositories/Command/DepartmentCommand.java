package com.example.java21Microservice.Repositories.Command;

import com.example.java21Microservice.DbEntities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentCommand extends JpaRepository<Department, Integer> {

}
