package com.example.java21Microservice.AR;

import com.example.java21Microservice.Repositories.Query.EmployeeRepository;
import com.example.java21Microservice.Request.GetEmployeeDetails;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEmployeeDetailsAr extends AbstractBaseAr<GetEmployeeDetails, List<EmployeeDetails>> {

    @Autowired
    EmployeeRepository repository;

    @Override
    protected List<EmployeeDetails> handle(GetEmployeeDetails request) {
        return repository.getEmployeeDetails(request);
    }
}
