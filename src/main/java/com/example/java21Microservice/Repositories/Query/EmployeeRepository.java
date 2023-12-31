package com.example.java21Microservice.Repositories.Query;

import com.example.java21Microservice.DbEntities.Employee;
import com.example.java21Microservice.ResponseModel.EmployeeDepartment;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class EmployeeRepository {

    public List<EmployeeDepartment> getEmployeeDepartmentDetails()
    {
        return new ArrayList<EmployeeDepartment>();
    }
}
