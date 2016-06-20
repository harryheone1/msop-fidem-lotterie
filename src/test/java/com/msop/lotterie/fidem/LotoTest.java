package com.msop.lotterie.fidem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.msop.lotterie.fidem.client.model.ConsoleModelTest;
import com.msop.lotterie.fidem.command.BuyCommandTest;
import com.msop.lotterie.fidem.command.CommandBuilderTest;
import com.msop.lotterie.fidem.command.LaunchCommandTest;
import com.msop.lotterie.fidem.command.ResultCommandTest;
import com.msop.lotterie.fidem.configuation.GameConfigurationTest;
import com.msop.lotterie.fidem.game.GameTest;
import com.msop.lotterie.fidem.validator.CommandOutEnumValidatorTest;
import com.msop.lotterie.fidem.validator.EmptyValidatorTest;
import com.msop.lotterie.fidem.validator.NumberScopeValidatorTest;
import com.msop.lotterie.fidem.validator.NumberValidatorTest;
import com.msop.lotterie.fidem.validator.ValidatorMappingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	NumberValidatorTest.class,
	ValidatorMappingTest.class,
	NumberScopeValidatorTest.class,
	EmptyValidatorTest.class,
	CommandOutEnumValidatorTest.class,
	ConsoleModelTest.class,
	GameTest.class,
	GameConfigurationTest.class,
	CommandBuilderTest.class,
	BuyCommandTest.class,
	LaunchCommandTest.class,
	ResultCommandTest.class,
	EntryWorkflowTest.class
}) 
public class LotoTest {
}
