package com.msop.lotterie.fidem.command;

import com.msop.lotterie.fidem.game.Game;

/**
 * The Interface Command.
 */
public interface Command {
	
	/**
	 * Execute.
	 *
	 * @param game the game
	 */
	void execute(Game game);
}
