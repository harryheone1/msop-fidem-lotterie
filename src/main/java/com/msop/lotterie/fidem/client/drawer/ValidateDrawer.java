package com.msop.lotterie.fidem.client.drawer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.msop.lotterie.fidem.client.model.ConsoleModel;
import com.msop.lotterie.fidem.validator.InputValidator;

/**
 * The Class ClientValidateController.
 */
public class ValidateDrawer implements Drawer {

	/** The basic drawer. */
	private Drawer basicDrawer;  	
	
	/** The validators. */
	private List<InputValidator> validators;
	

	/**
	 * Instantiates a new validate drawer.
	 *
	 * @param validators the validators
	 * @param basicDrawer the basic drawer
	 */
	public ValidateDrawer(List<InputValidator> validators, Drawer basicDrawer) {
		this.basicDrawer = basicDrawer;
		this.validators = validators;
	}


	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.drawer.Drawer#getInput(com.msop.lotterie.fidem.client.model.ConsoleModel)
	 */
	@Override
	public void getInput(ConsoleModel model) throws IOException {
		basicDrawer.getInput(model);

		Set<String> validationFailedMessage = new HashSet<String>();
		if (validators != null) {
			for (InputValidator validator : validators) {
				String error = validator.validate(model.getInputInfo());
				if (error != null) {
					validationFailedMessage.add(error);
				}
				
			}
		}
		if (!validationFailedMessage.isEmpty()) {
			model.setInputInfo(null);
			model.setValidatorErrorMessage(new ArrayList<String>(validationFailedMessage));
		}
	}

}
