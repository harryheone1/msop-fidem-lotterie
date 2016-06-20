package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.Test;

public class EmptyValidatorTest {

	@Test
	public void testNumberValidator() {
		InputValidator validator = new EmptyValidator("is empty");
		
		
		Assert.assertEquals(validator.validate(""), "is empty");
		Assert.assertEquals(validator.validate(null), "is empty");
		Assert.assertNull(validator.validate("123"));
	}

}
