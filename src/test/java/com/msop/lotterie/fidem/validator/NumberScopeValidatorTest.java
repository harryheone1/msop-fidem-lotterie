package com.msop.lotterie.fidem.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;

/**
 * The Class NumberScopeValidatorTest.
 */
public class NumberScopeValidatorTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	/**
	 * Test number validator.
	 */
	@Test
	public void testNumberValidator() {
		List<Integer> range = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i ++) {
			range.add(i);
		}
		
		InputValidator validator = new NumberScopeValidator(range, "scope wrong");
		
		Assert.assertEquals(validator.validate("a"), "scope wrong");
		Assert.assertEquals(validator.validate("1000"), "scope wrong");
		Assert.assertNull(validator.validate("5"));
		Assert.assertNull(validator.validate("100"));
		Assert.assertNull(validator.validate("1"));
	}
}
