package com.msop.lotterie.fidem.client.controller;

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
public class ClientValidateController implements Controller {

	/** The base controller. */
	private Controller baseController;  	
	
	/** The validators. */
	private List<InputValidator> validators;
	

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.Controller#inputRequest()
	 */
	public void output(ConsoleModel model) {
		baseController.output(model);
	}


	/**
	 * Instantiates a new client validate controller.
	 *
	 * @param prompt the prompt
	 * @param validators the validators
	 */
	public ClientValidateController(List<InputValidator> validators) {
		this.baseController = new BasicClientController();
		this.validators = validators;
	}


	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.Controller#inputPass()
	 */
	public void getInput(ConsoleModel model) throws IOException {
		baseController.getInput(model);

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


	public void outputError(ConsoleModel model) {
		baseController.outputError(model);
		
	}
}
