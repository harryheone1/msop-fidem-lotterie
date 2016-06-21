package com.msop.lotterie.fidem.configuation;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameConfigurationTest {
	@BeforeClass
    public static void beforeClass() {
    	GameConfiguration.getInstance(5, 7, 20.0);
    }

	@Test
	public void testGameConfigurationAvailableNumber() {
		Assert.assertTrue(GameConfiguration.getInstance().initAvailableNumber().contains(5));
	}

	@Test
	public void testGameConfigurationTotalAmount() {
		Assert.assertEquals(GameConfiguration.getInstance().getWinnerTotalAmount().intValue(), 100);
	}

	@Test
	public void testGameConfigurationShared() {
		Assert.assertEquals(GameConfiguration.getInstance().getSharedAmount(1).intValue(), 75);
		Assert.assertEquals(GameConfiguration.getInstance().getSharedAmount(2).intValue(), 15);
		Assert.assertEquals(GameConfiguration.getInstance().getSharedAmount(3).intValue(), 10);
		Assert.assertEquals(GameConfiguration.getInstance().getSharedAmount(4).intValue(), 0);
		Assert.assertEquals(GameConfiguration.getInstance().getSharedAmount(100).intValue(), 0);
		
	}
}
