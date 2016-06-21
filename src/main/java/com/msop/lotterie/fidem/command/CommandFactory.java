package com.msop.lotterie.fidem.command;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class CommandBuilder.
 */
public final class CommandFactory {

	/**
	 * Instantiates a new command builder.
	 */
	private CommandFactory() {
		
	}

	/**
	 * Builds the commands.
	 *
	 * @param commands the commands
	 * @return the list
	 */
	public static List<Command> findCommands(String... commands) {
		List<Command> results = new ArrayList<Command>();
		for (String inputCommand : commands) {
			Command command = findCommand(inputCommand);
			if (command != null) {
				results.add(command);
			}
		}
		return results;
	}

	/**
	 * Find command.
	 *
	 * @param commandName the command
	 * @return the command
	 */
	private static Command findCommand(String commandName) {
		for (CommandRules commandRule : CommandRules.values()) {
			if (commandEquals(commandRule.getCommandName(), commandName)) {
				return commandRule.getCommand();
			}
		}
		return null;
	}

	/**
	 * Command equals.
	 *
	 * @param command1 the command1
	 * @param command2 the command2
	 * @return true, if successful
	 */
	private static boolean commandEquals(String command1, String command2) {
		return command1 != null && command2 != null && command1.equalsIgnoreCase(command2.trim());
	}
}
