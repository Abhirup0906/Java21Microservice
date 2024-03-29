package com.example.java21Microservice.Repositories.Query;

import com.example.java21Microservice.DbEntities.Employee;
import com.example.java21Microservice.Request.GetEmployeeDetails;
import com.example.java21Microservice.Request.GetEngineerByType;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;

//https://jakarta.ee/specifications/persistence/3.0/jakarta-persistence-spec-3.0.html#a6961
@NoRepositoryBean
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<EmployeeDetails> getEngineerByType(GetEngineerByType request);
    List<EmployeeDetails> getEmployeeDetails(GetEmployeeDetails request);

}
