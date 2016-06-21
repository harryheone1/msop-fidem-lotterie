package com.msop.lotterie.fidem.client.drawer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.msop.lotterie.fidem.client.model.ConsoleModel;

/**
 * The Class ConsoleDrawer.
 */
public class ConsoleDrawer implements Drawer {

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.client.drawer.Drawer#getInput(com.msop.lotterie.fidem.client.model.ConsoleModel)
	 */
	@Override
	public void getInput(ConsoleModel model) throws IOException {
		InputStreamReader is_reader = new InputStreamReader(System.in);
		model.setInputInfo(new BufferedReader(is_reader).readLine());
	}

}
