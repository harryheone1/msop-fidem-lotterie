package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorMappingTest {

	@Test
	public void testValidatorMapping() {	
		assertEquals(ValidatorMapping.COMMAND.getContext(), "COMMAND");
		assertEquals(ValidatorMapping.COMMAND.getValidators().size(), 2);
		Assert.assertTrue(EmptyValidator.class.isInstance(ValidatorMapping.COMMAND.getValidators().get(0)));
		Assert.assertTrue(CommandOutEnumValidator.class.isInstance(ValidatorMapping.COMMAND.getValidators().get(1)));
	}

}
