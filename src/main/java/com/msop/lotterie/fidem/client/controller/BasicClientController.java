package com.msop.lotterie.fidem.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.msop.lotterie.fidem.GameConstant;
import com.msop.lotterie.fidem.client.model.ConsoleModel;

/**
 * The Class BasicClientController.
 */
public class BasicClientController implements Controller {
	

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.Controller#inputRequest()
	 */
	public void output(ConsoleModel model) {
		System.out.print(model.getOutputMessage());
	}
	
	public void outputError(ConsoleModel model) {
		if (model.getValidatorErrorMessage() != null) {
			for (String error : model.getValidatorErrorMessage()) {
				System.out.println(error + "\n" + GameConstant.VALIDATION_FAILED_MESSAGE_SUFFIX);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.Controller#inputPass()
	 */
	public void getInput(ConsoleModel model) throws IOException {
		InputStreamReader is_reader = new InputStreamReader(System.in);
		model.setInputInfo(new BufferedReader(is_reader).readLine());
	}
	
}
