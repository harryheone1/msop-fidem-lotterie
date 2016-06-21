package com.msop.lotterie.fidem.client.drawer;

import java.io.IOException;

import com.msop.lotterie.fidem.client.model.ConsoleModel;

/**
 * The Interface Drawer.
 */
public interface Drawer {

	/**
	 * Gets the input.
	 *
	 * @param model the model
	 * @return the input
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	void getInput(ConsoleModel model) throws IOException;
}
