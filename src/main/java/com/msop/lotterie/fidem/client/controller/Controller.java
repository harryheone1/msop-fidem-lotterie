package com.msop.lotterie.fidem.client.controller;

import java.io.IOException;

import com.msop.lotterie.fidem.client.model.ConsoleModel;


/**
 * The Interface Controller.
 */
public interface Controller {

	/**
	 * Output.
	 *
	 * @param model the model
	 */
	void output(ConsoleModel model);

	/**
	 * Output error.
	 *
	 * @param model the model
	 */
	void outputError(ConsoleModel model);
	
	/**
	 * Gets the input.
	 *
	 * @param model the model
	 * @return the input
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	void getInput(ConsoleModel model) throws IOException;
}
