package com.msop.lotterie.fidem.validator;

import com.msop.lotterie.fidem.command.CommandBuilder;

/**
 * The Class CommandOutEnumValidator.
 */
public class CommandOutEnumValidator implements InputValidator {

	/** The error message. */
	String errorMessage;
	
	/**
	 * Instantiates a new command out enum validator.
	 *
	 * @param errorMessage the error message
	 */
	public CommandOutEnumValidator(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.validator.InputValidator#validate(java.lang.String)
	 */
	public String validate(String input) {
		boolean isPassed = !CommandBuilder.buildCommands(input).isEmpty();
		if (!isPassed) {
			return errorMessage;
		}
		return null;
	}

}
