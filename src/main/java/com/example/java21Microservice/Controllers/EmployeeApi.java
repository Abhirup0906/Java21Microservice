package com.example.java21Microservice.Controllers;

import com.example.java21Microservice.DbEntities.Employee;
import com.example.java21Microservice.Repositories.Query.EmployeeRepository;
import com.example.java21Microservice.ResponseModel.EmployeeDepartment;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/getDevelopmentEngineer")
    public List<Employee> getDevelopmentEngineer() {

        return repository.getDevelopmentEngineer();
    }

    @GetMapping("/getEmployeeDetails")
    public List<EmployeeDetails> getEmployeeDetails() {
        return repository.getEmployeeDetails();
    }
}