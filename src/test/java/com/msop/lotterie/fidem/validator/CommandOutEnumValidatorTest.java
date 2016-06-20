package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.Test;

public class CommandOutEnumValidatorTest {

	@Test
	public void testCommandOutEnumValidator() {
		InputValidator validator = new CommandOutEnumValidator("command is bad");
		
		Assert.assertEquals(validator.validate("sth"), "command is bad");
		Assert.assertNull(validator.validate("achat  "));
	}

}
