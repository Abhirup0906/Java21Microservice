package com.example.java21Microservice.AR;

import com.example.java21Microservice.Repositories.Query.EmployeeRepository;
import com.example.java21Microservice.Request.GetEngineerByType;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEngineerByTypeAr extends AbstractBaseAr<GetEngineerByType, List<EmployeeDetails>> {

    @Autowired
    EmployeeRepository repository;

    @Override
    protected List<EmployeeDetails> handle(GetEngineerByType request) {
        return repository.getEngineerByType(request);
    }
}
