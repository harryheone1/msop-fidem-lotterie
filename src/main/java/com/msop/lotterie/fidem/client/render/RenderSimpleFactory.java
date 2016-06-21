package com.msop.lotterie.fidem.client.render;


/**
 * A factory for creating RenderSimple objects.
 */
public final class RenderSimpleFactory {

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public static Render getController() {
			return new ConsoleRender();
	}
}
