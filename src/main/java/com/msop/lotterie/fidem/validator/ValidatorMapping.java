package com.msop.lotterie.fidem.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.msop.lotterie.fidem.GameConstant;

/**
 * The Enum ValidatorMapping.
 */
public enum ValidatorMapping {

	/** The command. */
	COMMAND("COMMAND", new EmptyValidator(GameConstant.COMMAND_NOT_VALID), new CommandOutEnumValidator(GameConstant.COMMAND_NOT_VALID)),
	
	/** The name. */
	NAME("NAME", new EmptyValidator(GameConstant.NAME_NOT_VALID)),
	
	/** The number. */
	NUMBER("NUMBER", new EmptyValidator(GameConstant.NUMBER_NOT_VALID), new NumberValidator(GameConstant.NUMBER_NOT_VALID));

	/** The context. */
	private String context;
	
	/** The validators. */
	private List<InputValidator> validators;

	/**
	 * Instantiates a new validator mapping.
	 *
	 * @param context the context
	 * @param validators the validators
	 */
	private ValidatorMapping(String context, InputValidator... validators) {
		this.context = context;
		List<InputValidator> result = new ArrayList<InputValidator>();
		result.addAll(Arrays.asList(validators));
		this.validators = result;
	}

	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * Gets the validators.
	 *
	 * @return the validators
	 */
	public List<InputValidator> getValidators() {
		return validators;
	}


}
