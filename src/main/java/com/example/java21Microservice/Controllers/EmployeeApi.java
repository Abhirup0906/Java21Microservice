package com.example.java21Microservice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}