package com.msop.lotterie.fidem.client.drawer;

import java.util.List;

import com.msop.lotterie.fidem.validator.InputValidator;

/**
 * A factory for creating DrawerSimple objects.
 */
public final class DrawerSimpleFactory {

	/**
	 * Gets the controller.
	 *
	 * @param validators the validators
	 * @param basicDrawer the basic drawer
	 * @return the controller
	 */
	public static Drawer getController(List<InputValidator> validators, Drawer basicDrawer) {
		if (validators == null || validators.isEmpty()) {
			return new ConsoleDrawer();
		} else {
			return new ValidateDrawer(validators, basicDrawer);
		}
	}
}
