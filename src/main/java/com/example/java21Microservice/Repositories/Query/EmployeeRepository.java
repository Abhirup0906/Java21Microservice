package com.example.java21Microservice.Repositories.Query;

import com.example.java21Microservice.DbEntities.Employee;
import com.example.java21Microservice.DbEntities.Employee_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

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
}
