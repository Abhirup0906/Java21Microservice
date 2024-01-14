package com.example.java21Microservice.Repositories.Query.Impl;

import com.example.java21Microservice.DbEntities.Employee;
import com.example.java21Microservice.DbEntities.Employee_;
import com.example.java21Microservice.DbEntities.Person;
import com.example.java21Microservice.DbEntities.Person_;
import com.example.java21Microservice.Repositories.Query.EmployeeRepository;
import com.example.java21Microservice.Request.GetEmployeeDetails;
import com.example.java21Microservice.Request.GetEngineerByType;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends BaseRepo<Employee, Integer> implements EmployeeRepository {
    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(Employee.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeDetails> getEngineerByType(GetEngineerByType request)
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<EmployeeDetails> empQuery = builder.createQuery(EmployeeDetails.class);

        Root<Employee> root = empQuery.from(Employee.class);
        Join<Employee, Person> person = root.join(Employee_.person);

        empQuery.select(builder.construct(EmployeeDetails.class,
                root.get(Employee_.employeeId),
                person.get(Person_.personType),
                person.get(Person_.firstName),
                person.get(Person_.lastName),
                root.get(Employee_.gender),
                root.get(Employee_.hireDate)))
                .where(builder.equal(root.get(Employee_.JOB_TITLE), request.jobTitle()));

        return entityManager.createQuery(empQuery).getResultList();
    }

    @Override
    public List<EmployeeDetails> getEmployeeDetails(GetEmployeeDetails request)
    {
        // create builder
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        //create base query
        CriteriaQuery<EmployeeDetails> queryEmployee = builder.createQuery(EmployeeDetails.class);

        Root<Employee> employeeRoot = queryEmployee.from(Employee.class);
        Join<Employee, Person> person = employeeRoot.join(Employee_.person);

        // add selection
        queryEmployee.select(builder.construct(EmployeeDetails.class,
                employeeRoot.get(Employee_.employeeId),
                person.get(Person_.personType),
                person.get(Person_.firstName),
                person.get(Person_.lastName),
                employeeRoot.get(Employee_.gender),
                employeeRoot.get(Employee_.hireDate)));

        //add condition
        if (request.getEmployeeId() != 0) {
            queryEmployee.where(builder.equal(employeeRoot.get(Employee_.EMPLOYEE_ID), request.getEmployeeId()));
        }

        return entityManager.createQuery(queryEmployee).getResultList();
    }
}
