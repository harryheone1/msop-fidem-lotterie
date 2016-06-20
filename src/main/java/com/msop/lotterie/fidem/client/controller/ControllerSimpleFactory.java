package com.msop.lotterie.fidem.client.controller;

import java.util.List;

import com.msop.lotterie.fidem.validator.InputValidator;

/**
 * A factory for creating ControllerSimple objects.
 */
public final class ControllerSimpleFactory {

	/**
	 * Gets the controller.
	 *
	 * @param validators the validators
	 * @return the controller
	 */
	public static Controller getController(List<InputValidator> validators) {
		if (validators == null || validators.isEmpty()) {
			return new BasicClientController();
		} else {
			return new ClientValidateController(validators);
		}
	}
}
