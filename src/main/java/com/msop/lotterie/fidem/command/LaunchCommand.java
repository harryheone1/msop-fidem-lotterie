package com.msop.lotterie.fidem.command;

import java.util.concurrent.ThreadLocalRandom;

import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.game.Game;

/**
 * The Class LaunchCommand.
 */
public class LaunchCommand implements Command {

	/* (non-Javadoc)
	 * @see com.msop.lotterie.fidem.command.Command#execute(com.msop.lotterie.fidem.game.Game)
	 */
	public void execute(Game game) {
		for (int i = 0; i < GameConfiguration.getWinnerNumber(); i++) {
			Integer random = ThreadLocalRandom.current().nextInt(0, game.getAvailableNumer().size());
			game.getWinnerNumer().put(i, game.getAvailableNumer().get(random));
			game.getAvailableNumer().remove(random);
		}
		
	}

}
