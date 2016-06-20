package com.msop.lotterie.fidem.validator;

/**
 * The Class NumberValidator.
 */
public class NumberValidator implements InputValidator {
	/** The error message. */
	String errorMessage;

	/** The regex_number. */
	private static String regex_number = "[0-9]+";

	public String validate(String input) {
		if (!input.matches(regex_number)) {
			return errorMessage; 
		}
		return null;
	}

	/**
	 * Instantiates a new number validator.
	 *
	 * @param errorMessage the error message
	 */
	public NumberValidator(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

}
