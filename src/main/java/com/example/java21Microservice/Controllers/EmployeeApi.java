package com.example.java21Microservice.Controllers;

import com.example.java21Microservice.AR.AbstractBaseAr;
import com.example.java21Microservice.Request.GetEmployeeDetails;
import com.example.java21Microservice.Request.GetEngineerByType;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {

    @Autowired
    AbstractBaseAr<GetEngineerByType, List<EmployeeDetails>> getEngineerByTypeSvc;
    AbstractBaseAr<GetEmployeeDetails, List<EmployeeDetails>> getEmployeeDetailsSvc;


    @GetMapping("/getDevelopmentEngineer")
    public List<EmployeeDetails> getDevelopmentEngineer(@PathVariable String jobTitle) {

        return getEngineerByTypeSvc.handler(new GetEngineerByType(jobTitle));
    }

    @GetMapping("/getEmployeeDetails")
    public List<EmployeeDetails> getEmployeeDetails(@PathVariable Optional<Integer> employeeId) {
        var request = new GetEmployeeDetails();
        employeeId.ifPresent(request::setEmployeeId);
        return getEmployeeDetailsSvc.handler(request);
    }
}