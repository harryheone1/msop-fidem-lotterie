package com.msop.lotterie.fidem.command;

import org.junit.Assert;
import org.junit.Test;

import com.msop.lotterie.fidem.game.Game;

public class BuyCommandTest {

	@Test
	public void testBuyCommand() {
		BuyCommand command = new BuyCommand();
		Game game = new Game();
		game.getCommands().add(command);

		game.executeCommand();
		Assert.assertEquals(game.getBuyedNumber().get(Integer.valueOf(command.getNumberChosen())), command.getBuyerName());
		Assert.assertTrue(!game.getAvailableNumer().contains(command.getNumberChosen()));
	}

	@Test
	public void testBuyCommandException() {
		BuyCommand command = new BuyCommand();
		command.setIsTest(true);
		Game game = new Game();
		game.getCommands().add(command);

		game.executeCommand();
		Assert.assertEquals("Some errors happend when read or write data to console", command.getErrorMessage());
	}
}
