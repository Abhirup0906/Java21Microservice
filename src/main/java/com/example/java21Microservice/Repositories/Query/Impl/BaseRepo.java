package com.example.java21Microservice.Repositories.Query.Impl;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepo<T, ID> extends SimpleJpaRepository<T, ID> {
    protected EntityManager entityManager;

    public BaseRepo(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }
}
