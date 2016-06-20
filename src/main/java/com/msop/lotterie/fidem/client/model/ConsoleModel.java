package com.msop.lotterie.fidem.client.model;

import java.util.List;

/**
 * The Class ConsoleModel.
 */
public class ConsoleModel {

	/** The output message. */
	private String outputMessage;
	
	/** The input info. */
	private String inputInfo;
	
	/** The validator error message. */
	private List<String> validatorErrorMessage;

	/**
	 * Instantiates a new console model.
	 *
	 * @param outputMessage the output message
	 * @param inputInfo the input info
	 */
	public ConsoleModel(String outputMessage, String inputInfo) {
		this.outputMessage = outputMessage;
		this.inputInfo = inputInfo;
	}

	/**
	 * Instantiates a new console model.
	 */
	public ConsoleModel() {
	}

	/**
	 * Gets the output message.
	 *
	 * @return the output message
	 */
	public String getOutputMessage() {
		return outputMessage;
	}

	/**
	 * Sets the output message.
	 *
	 * @param outputMessage the new output message
	 */
	public void setOutputMessage(String outputMessage) {
		this.outputMessage = outputMessage;
	}

	/**
	 * Gets the input info.
	 *
	 * @return the input info
	 */
	public String getInputInfo() {
		return inputInfo;
	}

	/**
	 * Sets the input info.
	 *
	 * @param inputInfo the new input info
	 */
	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}

	/**
	 * Gets the validator error message.
	 *
	 * @return the validator error message
	 */
	public List<String> getValidatorErrorMessage() {
		return validatorErrorMessage;
	}

	/**
	 * Sets the validator error message.
	 *
	 * @param validatorErrorMessage the new validator error message
	 */
	public void setValidatorErrorMessage(List<String> validatorErrorMessage) {
		this.validatorErrorMessage = validatorErrorMessage;
	}
}
