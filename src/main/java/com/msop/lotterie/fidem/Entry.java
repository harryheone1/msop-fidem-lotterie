package com.msop.lotterie.fidem;

import java.io.IOException;

import com.msop.lotterie.fidem.client.GeneralClientFacade;
import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.game.Game;

/**
 * The Class Entry.
 *
 * @author hejunz
 */
public class Entry {

	/** The Constant GENERAL_INITIAL_NUMBER. */
	public static final Integer GENERAL_INITIAL_NUMBER = 100;
	
	/** The Constant GENERAL_MAX_COMMAND_PERGAME. */
	public static final Integer GENERAL_MAX_COMMAND_PERGAME = 200;

	/** The Constant GENERAL_FACTOR_WINNER_MONEY. */
	public static final Double GENERAL_FACTOR_WINNER_MONEY = 0.5;

	/** The Constant isSimple. */
	public static Boolean isSimple = false;
	
	/** The Constant SIMPLEL_INITIAL_NUMBER. */
	public static final Integer SIMPLEL_INITIAL_NUMBER = 5;
	
	/** The Constant SIMPLEL_MAX_COMMAND_PERGAME. */
	public static final Integer SIMPLEL_MAX_COMMAND_PERGAME = 7;

	/** The Constant SIMPLEL_FACTOR_WINNER_MONEY. */
	public static final Double SIMPLE_FACTOR_WINNER_MONEY = 20.0;
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			// Init
			GameConfiguration config = GameConfiguration.getInstance(GENERAL_INITIAL_NUMBER, GENERAL_MAX_COMMAND_PERGAME, GENERAL_FACTOR_WINNER_MONEY);
			if (isSimple) {
				config = GameConfiguration.getInstance(SIMPLEL_INITIAL_NUMBER, SIMPLEL_MAX_COMMAND_PERGAME, SIMPLE_FACTOR_WINNER_MONEY);
			}
			
			WorkflowEngine workflow = new WorkflowEngine(new Game());
			int count = 0;
			while(workflow.isContinue() && count < config.getMaxCommand()) {
				workflow.excute();
				count++;
			}
			// more than maximum command
			throw new IOException();
		} catch (IOException e) {
			String errorMessage = "Some errors happend of internal system.";
			GeneralClientFacade.getInstance().outputFetalErrorMessage(errorMessage);
		}
	}

}
