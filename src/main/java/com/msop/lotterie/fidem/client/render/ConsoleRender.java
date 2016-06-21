package com.msop.lotterie.fidem.client.render;

import com.msop.lotterie.fidem.GameConstant;
import com.msop.lotterie.fidem.client.model.ConsoleModel;

/**
 * The Class ConsoleRender.
 */
public class ConsoleRender implements Render {
	

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.render.Render#output(com.msop.lotterie.fidem.client.model.ConsoleModel)
	 */
	public void output(ConsoleModel model) {
		System.out.print(model.getOutputMessage());
	}
	
	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.render.Render#outputError(com.msop.lotterie.fidem.client.model.ConsoleModel)
	 */
	public void outputError(ConsoleModel model) {
		if (model.getValidatorErrorMessage() != null) {
			for (String error : model.getValidatorErrorMessage()) {
				System.out.println(error + "\n" + GameConstant.VALIDATION_FAILED_MESSAGE_SUFFIX);
			}
		}
	}
	

	
}
