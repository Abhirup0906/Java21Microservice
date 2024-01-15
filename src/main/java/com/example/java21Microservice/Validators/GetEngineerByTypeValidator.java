package com.example.java21Microservice.Validators;

import br.com.fluentvalidator.AbstractValidator;
import com.example.java21Microservice.Request.GetEngineerByType;
import org.springframework.stereotype.Component;

@Component
public class GetEngineerByTypeValidator extends AbstractValidator<GetEngineerByType> {

    @Override
    public void rules()
    {
        setPropertyOnContext(GetEngineerByType.class.getName());

        ruleFor(GetEngineerByType::jobTitle).must((x) -> {
            return !x.trim().isEmpty();
        }).withMessage("Job Title is not valid");
    }
}
