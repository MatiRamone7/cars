package com.mercel.cars.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarNameValidator implements ConstraintValidator<ContainsCar, String> {

	private final static String car = "car";

	@Override
	public void initialize(ContainsCar carName) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Ver si se puede hacer por expresiones regulares

//		String regex = "*car*";

//		String regex = ".*\\\\bcar\\\\b.*";

//		String regex = "car";
//		
//		boolean matches = Pattern.matches(regex, value);
//		
//		return matches;

		return value.contains(car);
	}

}
