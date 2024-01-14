package com.example.java21Microservice.Validators;

import br.com.fluentvalidator.AbstractValidator;
import com.example.java21Microservice.Request.GetEmployeeDetails;
import org.springframework.stereotype.Component;

@Component
public class GetEmployeeDetailsValidator extends AbstractValidator<GetEmployeeDetails> {
    @Override
    public void rules() {
        setPropertyOnContext(GetEmployeeDetails.class.getName());

        ruleFor(GetEmployeeDetails::getEmployeeId).must((x) -> {
            return true;
        }).withMessage("Employee Id must be greater than 0.");
    }
}
