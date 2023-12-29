package com.example.java21Microservice;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Java21MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java21MicroserviceApplication.class, args);
	}

}

//multiple data source: https://github.com/jahe/spring-boot-multiple-datasources
// https://www.baeldung.com/spring-data-jpa-multiple-databases#:~:text=Multiple%20Databases%20in%20Spring%20Boot&text=The%20interesting%20part%20is%20annotating,take%20care%20of%20the%20rest.

