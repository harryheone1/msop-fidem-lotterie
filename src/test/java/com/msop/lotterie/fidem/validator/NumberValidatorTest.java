package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;

public class NumberValidatorTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testNumberValidator() {
		InputValidator validator = new NumberValidator("number error");
		String errorMessage = validator.validate("abc");
		String errorMessageNull = validator.validate("1");
		
		
		Assert.assertEquals(errorMessage, "number error");
		Assert.assertNull(errorMessageNull);
	}

}
