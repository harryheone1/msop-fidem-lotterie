package com.msop.lotterie.fidem.command;

import com.msop.lotterie.fidem.GameConstant;

/**
 * The Enum CommandRules.
 */
public enum CommandRules {

	/** The buy. */
	BUY(GameConstant.COMMAND_ACHAT, new BuyCommand()),
	
	/** The launch. */
	LAUNCH(GameConstant.COMMAND_TIRAGE, new LaunchCommand()),
	
	/** The result. */
	RESULT(GameConstant.COMMAND_GAGNANTS, new ResultCommand());
	
	
	/** The input command. */
	private String commandName;
	
	/** The command. */
	private Command command;

	/**
	 * Instantiates a new command rules.
	 *
	 * @param inputCommand the input command
	 * @param command the command
	 */
	private CommandRules(String inputCommand, Command command) {
		this.commandName = inputCommand;
		this.command = command;
	}

	/**
	 * Gets the input command.
	 *
	 * @return the input command
	 */
	public String getCommandName() {
		return commandName;
	}

	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

}
