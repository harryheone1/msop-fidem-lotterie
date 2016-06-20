package com.msop.lotterie.fidem;

import java.io.IOException;

import com.msop.lotterie.fidem.client.controller.Controller;
import com.msop.lotterie.fidem.client.controller.ControllerSimpleFactory;
import com.msop.lotterie.fidem.client.model.ConsoleModel;
import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.game.Game;

/**
 * The Class Entry.
 *
 * @author hejunz
 */
public class Entry {

	/** The max command. */
	private static Integer maxCommand = GameConfiguration.MAX_COMMAND_PER_GAME;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			WorkflowEngine workflow = new WorkflowEngine(new Game());
			int count = 0;
			while(workflow.isContinue() && count < maxCommand) {
				workflow.excute();
				count++;
			}
			throw new IOException();
		} catch (IOException e) {
			String errorMessage = "Some errors happend of internal system.";
			ConsoleModel model = new ConsoleModel(errorMessage, null);
			Controller controller = ControllerSimpleFactory.getController(null);
			controller.output(model);
		}
	}
	
	/**
	 * Sets the max command.
	 *
	 * @param maxCommand the new max command
	 */
	public static void setMaxCommand(Integer maxCommandParam) {
		maxCommand = maxCommandParam;
	}
}
