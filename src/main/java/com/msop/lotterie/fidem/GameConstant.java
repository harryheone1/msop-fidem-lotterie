package com.msop.lotterie.fidem;

import com.msop.lotterie.fidem.command.CommandRules;

/**
 * The Class GameConstant.
 */
public final class GameConstant {

	/**
	 * Instantiates a new game constant.
	 */
	private GameConstant() {
		
	}

	/** The Constant INITIAL_MESSAGE. */
	public static final String INITIAL_MESSAGE = "The loto game is well started, please give the command among : ";

	/** The Constant COMMAND_FINISH_MESSAGE. */
	public static final String COMMAND_FINISH_MESSAGE = "The command is well done, please give the next command among : ";
	
	/** The Constant LOTO_FINISH_MESSAGE. */
	public static final String LOTO_FINISH_MESSAGE = "The loto is finished, let's restart again, please give the next command among : ";

	/** The Constant COMMAND_ACHAT. */
	public static final String COMMAND_ACHAT = "achat";
	
	/** The Constant COMMAND_TIRAGE. */
	public static final String COMMAND_TIRAGE = "tirage";
	
	/** The Constant COMMAND_GAGNANTS. */
	public static final String COMMAND_GAGNANTS = "gagnants";
	
	/** The Constant COMMAND_EXIT. */
	public static final String COMMAND_EXIT = "sortir";
	
	/** The Constant SPACE. */
	public static final String SPACE = " ";
	
	/** The Constant INPUT_NAMEL_MESSAGE. */
	public static final String INPUT_NAMEL_MESSAGE = "Please input your name: ";
	
	/** The Constant CHOOSE_NUMBER_MESSAGE. */
	public static final String CHOOSE_NUMBER_MESSAGE = "Please choose a number: ";
	
	/** The Constant COMMAND_NOT_VALID. */
	public static final String COMMAND_NOT_VALID = "The Command that you input is not valid ! ";
	
	/** The Constant NAME_NOT_VALID. */
	public static final String NAME_NOT_VALID = "The Name that you input is not valid ! ";
	
	/** The Constant NUMBER_NOT_VALID. */
	public static final String NUMBER_NOT_VALID = "The Number that you choose is not valid ! ";
	
	/** The Constant VALIDATION_FAILED_MESSAGE_SUFFIX. */
	public static final String VALIDATION_FAILED_MESSAGE_SUFFIX = "Please enter another one : ";
	
	/** The Constant FIRST_SUFFIX. */
	public static final String FIRST_SUFFIX = "ere";
	
	/** The Constant OTHER_SUFFIX. */
	public static final String OTHER_SUFFIX = "eme";
	
	/** The Constant RESULT_BOULE. */
	public static final String RESULT_BOULE = " boule";

	/** The Constant TWO_TAPE_SPACE. */
	public static final String TWO_TAPE_SPACE = "		";

	/** The Constant RESULT_DOLLAR. */
	public static final String RESULT_DOLLAR = "$";
	
	/**
	 * Gets the initial message.
	 *
	 * @return the initial message
	 */
	public static String getInitialMessage() {
		StringBuilder result = new StringBuilder(INITIAL_MESSAGE + "\n");
		for (CommandRules commandRules : CommandRules.values()) {
			result.append(commandRules.getCommandName()).append("\n");
		}
		return result.toString();
	}
	
	/**
	 * Gets the end message.
	 *
	 * @return the end message
	 */
	public static String getEndMessageOfCommand() {
		StringBuilder result = new StringBuilder(COMMAND_FINISH_MESSAGE + "\n");
		for (CommandRules commandRules : CommandRules.values()) {
			result.append(commandRules.getCommandName()).append("\n");
		}
		return result.toString();
	}
	
	/**
	 * Gets the end message.
	 *
	 * @return the end message
	 */
	public static String getEndMessageOfGame() {
		StringBuilder result = new StringBuilder(LOTO_FINISH_MESSAGE + "\n");
		for (CommandRules commandRules : CommandRules.values()) {
			result.append(commandRules.getCommandName()).append("\n");
		}
		return result.toString();
	}
}
