package com.msop.lotterie.fidem.client.model;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleModelTest {

	@Test
	public void testConsoleModelConstructor() {
		ConsoleModel model = new ConsoleModel();
		Assert.assertNull(model.getInputInfo());
		Assert.assertNull(model.getOutputMessage());
		Assert.assertNull(model.getValidatorErrorMessage());
		
	}

	@Test
	public void testConsoleModelSet() {
		ConsoleModel model = new ConsoleModel();
		model.setInputInfo("everybody");
		model.setOutputMessage("no no no");
		model.setValidatorErrorMessage(Arrays.asList("test"));
		Assert.assertEquals(model.getInputInfo(), "everybody");
		Assert.assertEquals(model.getOutputMessage(), "no no no");
		Assert.assertEquals(model.getValidatorErrorMessage().size(), 1);
		
	}

	@Test
	public void testConsoleModelConstructorField() {
		ConsoleModel model = new ConsoleModel("output", "input");
		Assert.assertEquals(model.getInputInfo(), "input");
		Assert.assertEquals(model.getOutputMessage(), "output");
	}
}
