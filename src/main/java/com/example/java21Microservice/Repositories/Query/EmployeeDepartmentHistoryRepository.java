package com.example.java21Microservice.Repositories.Query;

import com.example.java21Microservice.DbEntities.EmployeeDepartmentHistory;
import com.example.java21Microservice.DbEntities.EmployeeDepartmentHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDepartmentHistoryRepository extends JpaRepository<EmployeeDepartmentHistory, EmployeeDepartmentHistoryId> {
}
