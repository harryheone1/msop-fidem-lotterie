package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;

public class CommandOutEnumValidatorTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testCommandOutEnumValidator() {
		InputValidator validator = new CommandOutEnumValidator("command is bad");
		
		Assert.assertEquals(validator.validate("sth"), "command is bad");
		Assert.assertNull(validator.validate("achat  "));
	}

}
