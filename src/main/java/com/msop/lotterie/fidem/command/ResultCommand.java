package com.msop.lotterie.fidem.command;

import java.io.IOException;

import com.msop.lotterie.fidem.GameConstant;
import com.msop.lotterie.fidem.client.GeneralClientFacade;
import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.game.Game;
import com.msop.lotterie.fidem.validator.ValidatorMapping;

/**
 * The Class ResultCommand.
 */
public class ResultCommand implements Command {

	/** The error message. */
	private String errorMessage;

	/** The is test. */
	private Boolean isTest = false;

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.command.Command#execute(com.msop.lotterie.fidem.game.Game)
	 */
	public void execute(Game game) {
		int count = 1;
		StringBuilder line1 = new StringBuilder();
		StringBuilder line2 = new StringBuilder();
		for (Integer order : game.getWinnerNumer().keySet()) {
			String money = String.valueOf(GameConfiguration.getInstance().getSharedAmount(count));
			line1.append(count).append(getSuffix(count)).append(GameConstant.RESULT_BOULE);
			String winnerName = game.getBuyedNumber().get(game.getWinnerNumer().get(order));
			String outputName = winnerName != null ? winnerName : GameConstant.SPACE;
			line2.append(outputName).append(" : ").append(money).append(GameConstant.RESULT_DOLLAR);
			Boolean line1Longer = line1.length() - line2.length() >= 0;
			Integer lengthToAppend = Math.abs(line1.length() - line2.length());
			for (int i = 0; i < lengthToAppend; i++) {
				if (line1Longer) {
					line2.append(GameConstant.SPACE);
				} else {
					line1.append(GameConstant.SPACE);
				}
			}
			count++;
			line1.append(GameConstant.TWO_TAPE_SPACE);
			line2.append(GameConstant.TWO_TAPE_SPACE);
		}
		try {
			if (isTest) {
				throw new IOException();
			}
			String result = (line1.append("\n").append(line2).append("\n").append(GameConstant.getEndMessageOfGame())).toString();
			GeneralClientFacade.getInstance().getInputWithValidation(result, ValidatorMapping.COMMAND.getValidators());
		} catch (IOException e) {
			this.errorMessage = "Some errors happend when read or write data to console";
			GeneralClientFacade.getInstance().outputFetalErrorMessage(errorMessage);
		}
	}

	/**
	 * Gets the suffix.
	 *
	 * @param count the count
	 * @return the suffix
	 */
	private String getSuffix(int count) {
		if (count == 1) {
			return GameConstant.FIRST_SUFFIX;
		} else {
			return GameConstant.OTHER_SUFFIX; 
		}
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
