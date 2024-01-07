package com.example.java21Microservice.Repositories.Query.Impl;

import com.example.java21Microservice.DbEntities.Employee;
import com.example.java21Microservice.DbEntities.Employee_;
import com.example.java21Microservice.DbEntities.Person;
import com.example.java21Microservice.DbEntities.Person_;
import com.example.java21Microservice.Repositories.Query.EmployeeRepository;
import com.example.java21Microservice.ResponseModel.EmployeeDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends BaseRepo<Employee, Integer> implements EmployeeRepository {
    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(Employee.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getDevelopmentEngineer()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> empQuery = builder.createQuery(Employee.class);
        Root<Employee> root = empQuery.from(Employee.class);
        //ParameterExpression<Long> value = builder.parameter(Long.class);
        empQuery.select(root).where(builder.equal(root.get(Employee_.JOB_TITLE), "Research and Development Engineer"));

        //TypedQuery<Contact> query = em.createQuery(contactQuery);
        //query.setParameter(value, id);
        return entityManager.createQuery(empQuery).getResultList();
    }

    @Override
    public List<EmployeeDetails> getEmployeeDetails()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<EmployeeDetails> queryEmployee = builder.createQuery(EmployeeDetails.class);

        Root<Employee> employeeRoot = queryEmployee.from(Employee.class);
        //employeeRoot.fetch(Employee_.person, JoinType.INNER);
        Join<Employee, Person> person = employeeRoot.join(Employee_.person);

        queryEmployee.select(builder.construct(EmployeeDetails.class,
                employeeRoot.get(Employee_.employeeId),
                person.get(Person_.personType),
                person.get(Person_.firstName),
                person.get(Person_.lastName),
                employeeRoot.get(Employee_.gender),
                employeeRoot.get(Employee_.hireDate)));

        return entityManager.createQuery(queryEmployee).getResultList();
    }
}
