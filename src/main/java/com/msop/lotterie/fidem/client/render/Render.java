package com.msop.lotterie.fidem.client.render;

import com.msop.lotterie.fidem.client.model.ConsoleModel;


/**
 * The Interface Controller.
 */
public interface Render {

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
	
	
}
