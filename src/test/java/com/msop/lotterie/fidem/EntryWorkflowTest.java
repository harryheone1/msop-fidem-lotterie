package com.msop.lotterie.fidem;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msop.lotterie.fidem.configuation.GameConfiguration;
import com.msop.lotterie.fidem.game.Game;

public class EntryWorkflowTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void integrationTestSimple() throws IOException {
		Entry.isSimple = true;
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
