package com.msop.lotterie.fidem.validator;

import java.util.List;

/**
 * The Class NumberScopeValidator.
 */
public class NumberScopeValidator implements InputValidator {
	
	/** The scope. */
	List<Integer> scope;

	/**
	 * Instantiates a new number scope validator.
	 *
	 * @param scope the scope
	 * @param errorMessage the error message
	 */
	public NumberScopeValidator(List<Integer> scope, String errorMessage) {
		super();
		this.scope = scope;
		this.errorMessage = errorMessage;
	}


	/** The error message. */
	String errorMessage;
	

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.validator.InputValidator#validate(java.lang.String)
	 */
	public String validate(String input) {

		
		try {
			if (scope != null && !scope.contains(Integer.valueOf(input))) {
				return errorMessage;
			}
		} catch (NumberFormatException e) {
			return errorMessage;
		}
		return null;
	}

}
