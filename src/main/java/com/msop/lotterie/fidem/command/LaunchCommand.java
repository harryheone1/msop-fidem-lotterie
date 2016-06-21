package com.msop.lotterie.fidem.command;

import java.util.LinkedList;
import java.util.List;
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
		List<Integer> tempList = new LinkedList<Integer>(game.getInitialAvailableNumer());
		for (int i = 0; i < GameConfiguration.getInstance().getWinnerNumber(); i++) {
			Integer random = ThreadLocalRandom.current().nextInt(0, tempList.size());
			game.getWinnerNumer().put(i, tempList.get(random));
			tempList.remove(i);
		}
		tempList = null;
	}

}
