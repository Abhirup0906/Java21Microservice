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

    @Autowired
    AbstractBaseAr<GetEmployeeDetails, List<EmployeeDetails>> getEmployeeDetailsSvc;


    @GetMapping("/getDevelopmentEngineer")
    public List<EmployeeDetails> getDevelopmentEngineer(String jobTitle) {

        return getEngineerByTypeSvc.handler(new GetEngineerByType(jobTitle));
    }

    @GetMapping("/getEmployeeDetails")
    public List<EmployeeDetails> getEmployeeDetails(Optional<Integer> employeeId) {
        var request = new GetEmployeeDetails();
        if (employeeId.isPresent()) {
            request.setEmployeeId(employeeId.get());
        }
        else {
            request.setEmployeeId(0);
        }
        return getEmployeeDetailsSvc.handler(request);
    }
}