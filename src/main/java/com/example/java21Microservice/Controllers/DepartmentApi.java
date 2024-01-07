package com.example.java21Microservice.Controllers;

import com.example.java21Microservice.DbEntities.Department;
//import com.example.java21Microservice.QueryConfig;
import com.example.java21Microservice.Repositories.Query.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/department")
public class DepartmentApi {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentApi(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @GetMapping("/getDepartment")
    public @ResponseBody Iterable<Department> getDepartment() {
        return departmentRepository.findAll();
    }
}
