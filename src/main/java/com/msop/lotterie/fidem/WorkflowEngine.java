package com.msop.lotterie.fidem;

import java.io.IOException;

import com.msop.lotterie.fidem.client.controller.ControllerWrapper;
import com.msop.lotterie.fidem.command.CommandFactory;
import com.msop.lotterie.fidem.game.Game;
import com.msop.lotterie.fidem.validator.ValidatorMapping;

/**
 * The Class WorkflowEngine.
 */
public class WorkflowEngine {
	
	/** The game. */
	private Game game;

	/** The command. */
	private String command;

	/**
	 * Instantiates a new workflow engine.
	 *
	 * @param game the game
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public WorkflowEngine(Game game) throws IOException {
		super();
		this.game = game;
		init();
	}

	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Excute.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void excute() throws IOException {
		game.getCommands().clear();
		game.getCommands().addAll(CommandFactory.buildCommands(this.command));
		game.executeCommand();
		
		this.command = ControllerWrapper.getInputWithValidation(GameConstant.getEndMessageOfCommand(), ValidatorMapping.COMMAND.getValidators());
	}

	/**
	 * Inits the.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void init() throws IOException {
		this.command = ControllerWrapper.getInputWithValidation(GameConstant.getInitialMessage(), ValidatorMapping.COMMAND.getValidators());
	}
	
	/**
	 * Checks if is continue.
	 *
	 * @return true, if is continue
	 */
	public boolean isContinue() {
		return this.command != null;
	}
}
