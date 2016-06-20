package com.msop.lotterie.fidem.configuation;

import org.junit.Assert;
import org.junit.Test;

public class GameConfigurationTest {

	@Test
	public void testGameConfigurationAvailableNumber() {
		Assert.assertEquals(GameConfiguration.initAvailableNumber().size(), GameConfiguration.INITIAL_NUMBER.intValue());
		Assert.assertTrue(GameConfiguration.initAvailableNumber().contains(200));
	}

	@Test
	public void testGameConfigurationTotalAmount() {
		Assert.assertEquals(GameConfiguration.getWinnerTotalAmount().intValue(), 100);
	}

	@Test
	public void testGameConfigurationShared() {
		Assert.assertEquals(GameConfiguration.getSharedAmount(1).intValue(), 75);
		Assert.assertEquals(GameConfiguration.getSharedAmount(2).intValue(), 15);
		Assert.assertEquals(GameConfiguration.getSharedAmount(3).intValue(), 10);
		Assert.assertEquals(GameConfiguration.getSharedAmount(4).intValue(), 0);
		Assert.assertEquals(GameConfiguration.getSharedAmount(100).intValue(), 0);
		
	}
}
