package com.msop.lotterie.fidem.command;

import java.io.IOException;
import java.util.List;

import com.msop.lotterie.fidem.GameConstant;
import com.msop.lotterie.fidem.client.GeneralClientFacade;
import com.msop.lotterie.fidem.game.Game;
import com.msop.lotterie.fidem.validator.InputValidator;
import com.msop.lotterie.fidem.validator.NumberScopeValidator;
import com.msop.lotterie.fidem.validator.ValidatorMapping;

/**
 * The Class BuyCommand.
 */
public class BuyCommand implements Command {

	/** The buyer name. */
	private String buyerName;
	
	/** The number chosen. */
	private String numberChosen;
	
	/** The error message. */
	private String errorMessage;

	/** The is test. */
	private Boolean isTest = false;

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.command.Command#execute(com.msop.lotterie.fidem.game.Game)
	 */
	public void execute(Game game) {
		try {
			if (isTest) {
				throw new IOException();
			}
			// ask name
			String buyerName = GeneralClientFacade.getInstance().getInputWithValidation(GameConstant.INPUT_NAMEL_MESSAGE, ValidatorMapping.NAME.getValidators());
			this.buyerName = buyerName;
			
			// Add special validation of number input
			List<InputValidator> validatorNumber = ValidatorMapping.NUMBER.getValidators();
			validatorNumber.add(new NumberScopeValidator(game.getAvailableNumer(), GameConstant.NUMBER_NOT_VALID));
			String numberChosenString = GeneralClientFacade.getInstance().getInputWithValidation(GameConstant.CHOOSE_NUMBER_MESSAGE, validatorNumber);
			this.numberChosen = numberChosenString;
			// ask number
			Integer numberChosen = Integer.valueOf(numberChosenString);

			// change game
			game.getAvailableNumer().remove(numberChosen);
			game.getBuyedNumber().put(numberChosen, buyerName);
			

		} catch (IOException e) {
			this.errorMessage = "Some errors happend when read or write data to console";
			GeneralClientFacade.getInstance().outputFetalErrorMessage(errorMessage);
		}
		
	}

	/**
	 * Gets the buyer name.
	 *
	 * @return the buyer name
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * Gets the number chosen.
	 *
	 * @return the number chosen
	 */
	public String getNumberChosen() {
		return numberChosen;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the checks if is test.
	 *
	 * @param isTest the new checks if is test
	 */
	public void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}
}
