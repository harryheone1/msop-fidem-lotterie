package com.msop.lotterie.fidem.command;

import org.junit.Assert;
import org.junit.Test;

import com.msop.lotterie.fidem.game.Game;

/**
 * The Class LaunchCommandTest.
 */
public class LaunchCommandTest {
	
	/**
	 * Test launch command.
	 */
	@Test
	public void testLaunchCommand() {
		LaunchCommand command = new LaunchCommand();
		Game game = new Game();
		game.getCommands().add(command);

		game.executeCommand();
		Assert.assertEquals(game.getWinnerNumer().size(), 3);
	}
}
