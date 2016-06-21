package com.msop.lotterie.fidem.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.msop.lotterie.fidem.command.Command;
import com.msop.lotterie.fidem.configuation.GameConfiguration;


/**
 * The Class Game.
 */
public class Game {

	/** The initial available numer. */
	private final List<Integer> initialAvailableNumer = new LinkedList<Integer>();

	/** The available numer. */
	private List<Integer> availableNumer = new LinkedList<Integer>();
	
	/** The buyed number. */
	private Map<Integer, String> buyedNumber = new HashMap<Integer, String>();
	
	/** The winner numer. */
	private Map<Integer, Integer> winnerNumer = new HashMap<Integer, Integer>();;

	/** The command. */
	private List<Command> commands;
	
	{
		availableNumer.addAll(GameConfiguration.getInstance().initAvailableNumber());
		initialAvailableNumer.addAll(GameConfiguration.getInstance().initAvailableNumber());
	}

	/**
	 * Gets the available numer.
	 *
	 * @return the available numer
	 */
	public List<Integer> getAvailableNumer() {
		return availableNumer;
	}

	/**
	 * Gets the buyed number.
	 *
	 * @return the buyed number
	 */
	public Map<Integer, String> getBuyedNumber() {
		return buyedNumber;
	}

	/**
	 * Gets the winner numer.
	 *
	 * @return the winner numer
	 */
	public Map<Integer, Integer> getWinnerNumer() {
		return winnerNumer;
	}


	/**
	 * Gets the commands.
	 *
	 * @return the commands
	 */
	public List<Command> getCommands() {
		if (commands == null) {
			this.commands = new ArrayList<Command>();
		}
		return commands;
	}

	/**
	 * Execute command.
	 */
	public void executeCommand() {
		if (this.commands != null) {
			for (Command command : this.commands) {
				if (command != null) {
					command.execute(this);
				}
			}
		}
	}

	/**
	 * Gets the initial available numer.
	 *
	 * @return the initial available numer
	 */
	public List<Integer> getInitialAvailableNumer() {
		return initialAvailableNumer;
	}

}
