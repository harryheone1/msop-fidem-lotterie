package com.msop.lotterie.fidem.validator;

/**
 * The Class EmptyValidator.
 */
public class EmptyValidator implements InputValidator {
	
	/** The error message. */
	String errorMessage;

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.validator.InputValidator#validate(java.lang.String)
	 */
	public String validate(String input) {
		if (input == null || input.isEmpty()) {
			return errorMessage;
		}
		return null;
	}

	/**
	 * Instantiates a new empty validator.
	 *
	 * @param errorMessage the error message
	 */
	public EmptyValidator(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

}
