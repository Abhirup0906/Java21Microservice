package com.example.java21Microservice.Controllers;

import com.example.java21Microservice.DbEntities.EmployeeDepartmentHistory;
import com.example.java21Microservice.Repositories.Query.EmployeeDepartmentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EmployeeDepartmentHistory")
public class EmployeeDepartmentHistoryApi {

    @Autowired
    private EmployeeDepartmentHistoryRepository repository;

    @GetMapping("")
    public Iterable<EmployeeDepartmentHistory> Get(){
        return repository.findAll();
    }
}
