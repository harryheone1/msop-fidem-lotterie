package com.msop.lotterie.fidem.command;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.GameConstant;
import com.msop.lotterie.fidem.configuation.GameConfiguration;

public class CommandBuilderTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testCommandBuilderAll() {
		List<Command> allCommands = CommandFactory.findCommands(GameConstant.COMMAND_ACHAT, GameConstant.COMMAND_TIRAGE, GameConstant.COMMAND_GAGNANTS, GameConstant.COMMAND_EXIT);
		
		Assert.assertEquals(allCommands.size(), 3);
		Assert.assertTrue(BuyCommand.class.isInstance(allCommands.get(0)));
		Assert.assertTrue(LaunchCommand.class.isInstance(allCommands.get(1)));
		Assert.assertTrue(ResultCommand.class.isInstance(allCommands.get(2)));
	}

	@Test
	public void testCommandBuilderFault() {
		List<Command> allCommands = CommandFactory.findCommands("Wrong");
		Assert.assertEquals(allCommands.size(), 0);
	}
}
