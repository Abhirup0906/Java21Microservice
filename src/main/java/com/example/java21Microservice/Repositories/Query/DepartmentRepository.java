package com.example.java21Microservice.Repositories.Query;

import com.example.java21Microservice.DbEntities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
