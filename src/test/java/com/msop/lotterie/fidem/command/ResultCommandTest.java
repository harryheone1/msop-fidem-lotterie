package com.msop.lotterie.fidem.command;

import org.junit.Assert;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.game.Game;

public class ResultCommandTest {

	@Test
	public void testBuyCommand() {
		ResultCommand command = new ResultCommand();
		Game game = new Game();
		game.getCommands().add(new LaunchCommand());
		game.getCommands().add(command);
		for (int i = 0; i < GameConfiguration.INITIAL_NUMBER; i++) {
			game.getBuyedNumber().put(i, String.valueOf(i) + "p");
		}

		game.executeCommand();
	}
	
	@Test
	public void testBuyCommandAotherName() {
		ResultCommand command = new ResultCommand();
		Game game = new Game();
		game.getCommands().add(new LaunchCommand());
		game.getCommands().add(command);
		for (int i = 0; i < GameConfiguration.INITIAL_NUMBER; i++) {
			game.getBuyedNumber().put(i, String.valueOf(i) + "pencipaikdiag");
		}

		game.executeCommand();
	}

	@Test
	public void testBuyCommandException() {
		ResultCommand command = new ResultCommand();
		command.setIsTest(true);
		Game game = new Game();
		game.getCommands().add(new LaunchCommand());
		game.getCommands().add(command);

		game.executeCommand();
		Assert.assertEquals("Some errors happend when read or write data to console", command.getErrorMessage());
	}
}
