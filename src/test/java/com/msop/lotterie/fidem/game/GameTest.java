package com.msop.lotterie.fidem.game;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.command.BuyCommand;
import com.msop.lotterie.fidem.configuation.GameConfiguration;

public class GameTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testGameConstructor() {
		Game game = new Game();
		Assert.assertTrue(game.getBuyedNumber().isEmpty());
		Assert.assertTrue(game.getWinnerNumer().isEmpty());
		Assert.assertTrue(game.getCommands().isEmpty());
		Assert.assertEquals(game.getAvailableNumer().size(), GameConfiguration.getInstance().initAvailableNumber().size());
		
		game.getCommands().add(new BuyCommand());
		Assert.assertEquals(game.getCommands().size(), 1);
		
	}


}
