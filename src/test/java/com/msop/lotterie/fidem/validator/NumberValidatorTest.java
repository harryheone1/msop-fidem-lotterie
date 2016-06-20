package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.Test;

public class NumberValidatorTest {

	@Test
	public void testNumberValidator() {
		InputValidator validator = new NumberValidator("number error");
		String errorMessage = validator.validate("abc");
		String errorMessageNull = validator.validate("1");
		
		
		Assert.assertEquals(errorMessage, "number error");
		Assert.assertNull(errorMessageNull);
	}

}
