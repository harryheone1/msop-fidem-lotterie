package com.msop.lotterie.fidem.client.controller;

import java.io.IOException;
import java.util.List;

import com.msop.lotterie.fidem.client.model.ConsoleModel;
import com.msop.lotterie.fidem.validator.InputValidator;

/**
 * The Class ControllerWrapper.
 */
public class ControllerWrapper {


	/**
	 * Gets the input with validation.
	 *
	 * @param prompt the prompt
	 * @param validators the validators
	 * @return the input with validation
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String getInputWithValidation(String prompt, List<InputValidator> validators) throws IOException {
		ConsoleModel model = new ConsoleModel(prompt, null);
		Controller controller = ControllerSimpleFactory.getController(validators);
		controller.output(model);
		controller.getInput(model);
		while (model.getInputInfo() == null && (model.getValidatorErrorMessage() != null && !model.getValidatorErrorMessage().isEmpty())) {
			controller.outputError(model);
			controller.getInput(model);
		}
		return model.getInputInfo();
	}

	
}
