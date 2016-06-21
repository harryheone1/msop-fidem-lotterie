package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;

public class EmptyValidatorTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testNumberValidator() {
		InputValidator validator = new EmptyValidator("is empty");
		
		
		Assert.assertEquals(validator.validate(""), "is empty");
		Assert.assertEquals(validator.validate(null), "is empty");
		Assert.assertNull(validator.validate("123"));
	}

}
