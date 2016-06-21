package com.msop.lotterie.fidem.client;

import java.io.IOException;
import java.util.List;

import com.msop.lotterie.fidem.client.drawer.Drawer;
import com.msop.lotterie.fidem.client.drawer.DrawerSimpleFactory;
import com.msop.lotterie.fidem.client.model.ConsoleModel;
import com.msop.lotterie.fidem.client.render.Render;
import com.msop.lotterie.fidem.client.render.RenderSimpleFactory;
import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.validator.InputValidator;

/**
 * The Class GeneralClientFacade.
 */
public class GeneralClientFacade {

	/** The instance. */
	private static GeneralClientFacade instance = null;

	/**
	 * Instantiates a new general client facade.
	 */
	private GeneralClientFacade() {
	}

	/**
	 * Gets the single instance of GeneralClientFacade.
	 *
	 * @return single instance of GeneralClientFacade
	 */
	public static GeneralClientFacade getInstance() {
		if (instance == null) {
			synchronized (GeneralClientFacade.class) {
				if (instance == null) {
					instance = new GeneralClientFacade();
				}
			}
		}
		return instance;
	}
	

	/**
	 * Gets the input with validation.
	 *
	 * @param prompt the prompt
	 * @param validators the validators
	 * @return the input with validation
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getInputWithValidation(String prompt, List<InputValidator> validators) throws IOException {
		ConsoleModel model = new ConsoleModel(prompt, null);
		// Render and output
		Render render = RenderSimpleFactory.getController();
		render.output(model);

		Drawer drawer = DrawerSimpleFactory.getController(validators, GameConfiguration.getInstance().getDrawer());
		drawer.getInput(model);
		// Ask user to input till we have good input passed validation
		while (model.getInputInfo() == null && (model.getValidatorErrorMessage() != null && !model.getValidatorErrorMessage().isEmpty())) {
			render.outputError(model);
			drawer.getInput(model);
		}
		return model.getInputInfo();
	}

	/**
	 * Output fetal error message.
	 *
	 * @param errorMessage the error message
	 */
	public void outputFetalErrorMessage(String errorMessage) {
		ConsoleModel model = new ConsoleModel(errorMessage + "\n", null);
		Render controller = RenderSimpleFactory.getController();
		controller.output(model);
	}
}
