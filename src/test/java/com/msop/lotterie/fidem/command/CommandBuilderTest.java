package com.msop.lotterie.fidem.command;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.msop.lotterie.fidem.GameConstant;

public class CommandBuilderTest {
	@Test
	public void testCommandBuilderAll() {
		List<Command> allCommands = CommandFactory.buildCommands(GameConstant.COMMAND_ACHAT, GameConstant.COMMAND_TIRAGE, GameConstant.COMMAND_GAGNANTS, GameConstant.COMMAND_EXIT);
		
		Assert.assertEquals(allCommands.size(), 3);
		Assert.assertTrue(BuyCommand.class.isInstance(allCommands.get(0)));
		Assert.assertTrue(LaunchCommand.class.isInstance(allCommands.get(1)));
		Assert.assertTrue(ResultCommand.class.isInstance(allCommands.get(2)));
	}

	@Test
	public void testCommandBuilderFault() {
		List<Command> allCommands = CommandFactory.buildCommands("Wrong");
		Assert.assertEquals(allCommands.size(), 0);
	}
}
