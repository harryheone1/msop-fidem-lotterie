package com.msop.lotterie.fidem;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.msop.lotterie.fidem.game.Game;

public class EntryWorkflowTest {

	@Test
	public void integrationTest() throws IOException {
		Entry.setMaxCommand(5);
		Entry.main(null);
	}

	@Test
	public void worlflowTest() throws IOException {
		WorkflowEngine workflow = new WorkflowEngine(new Game());
		Assert.assertTrue(workflow.getGame() != null);
		workflow.setGame(null);
		Assert.assertTrue(workflow.getGame() == null);
	}
}
