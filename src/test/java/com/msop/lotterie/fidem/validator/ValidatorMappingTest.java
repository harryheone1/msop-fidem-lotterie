package com.msop.lotterie.fidem.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;

import static org.junit.Assert.assertEquals;

public class ValidatorMappingTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testValidatorMapping() {	
		assertEquals(ValidatorMapping.COMMAND.getContext(), "COMMAND");
		assertEquals(ValidatorMapping.COMMAND.getValidators().size(), 2);
		Assert.assertTrue(EmptyValidator.class.isInstance(ValidatorMapping.COMMAND.getValidators().get(0)));
		Assert.assertTrue(CommandOutEnumValidator.class.isInstance(ValidatorMapping.COMMAND.getValidators().get(1)));
	}

}
