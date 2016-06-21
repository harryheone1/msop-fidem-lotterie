package com.msop.lotterie.fidem.configuation;

import java.util.ArrayList;
import java.util.List;

import com.msop.lotterie.fidem.client.drawer.ConsoleDrawer;
import com.msop.lotterie.fidem.client.drawer.Drawer;

/**
 * The Class GameConfiguration.
 */
public class GameConfiguration {

	/** The instance. */
	private static GameConfiguration instance = null;

	/** The initial number. */
	private Integer initialNumber;

	/** The max command per game. */
	private Integer maxCommandPerGame;

	/** The factor to win. */
	private Double factorToWin;
	
	/** The drawer. */
	private Drawer drawer = new ConsoleDrawer();
	

	/**
	 * Gets the drawer.
	 *
	 * @return the drawer
	 */
	public Drawer getDrawer() {
		return drawer;
	}

	/**
	 * Instantiates a new game configuration.
	 *
	 * @param initialNumber the initial number
	 * @param maxCommandPerGame the max command per game
	 * @param factorToWin the factor to win
	 */
	private GameConfiguration(Integer initialNumber, Integer maxCommandPerGame,
			Double factorToWin) {
		this.initialNumber = initialNumber;
		this.maxCommandPerGame = maxCommandPerGame;
		this.factorToWin = factorToWin;
	}

	/**
	 * Gets the single instance of GameConfiguration.
	 *
	 * @param initialNumber the initial number
	 * @param maxCommandPerGame the max command per game
	 * @param factorToWin the factor to win
	 * @return single instance of GameConfiguration
	 */
	public static GameConfiguration getInstance(Integer initialNumber, Integer maxCommandPerGame,
			Double factorToWin) {
		if (instance == null) {
			synchronized (GameConfiguration.class) {
				if (instance == null) {
					instance = new GameConfiguration(initialNumber, maxCommandPerGame, factorToWin);
				}
			}
		}
		return instance;
	}

	/**
	 * Gets the single instance of GameConfiguration.
	 *
	 * @return single instance of GameConfiguration
	 */
	public static GameConfiguration getInstance() {
		return instance;
	}
			
	/**
	 * Gets the max command.
	 *
	 * @return the max command
	 */
	public Integer getMaxCommand() {
		return this.maxCommandPerGame;
	}

	/**
	 * Inits the available number.
	 *
	 * @return the list
	 */
	public List<Integer> initAvailableNumber() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < initialNumber; i++) {
			result.add(i + 1);
		}
		return result;
	}

	/**
	 * Gets the shared amount.
	 *
	 * @param key the key
	 * @return the shared amount
	 */
	public Integer getSharedAmount(Integer key) {
		Double sharedRate = getShared(key);
		if (sharedRate != null) {
			return (int) (sharedRate * getWinnerTotalAmount());
		} else {
			return 0;
		}

	}

	/**
	 * Gets the winner total amount.
	 *
	 * @return the winner total amount
	 */
	public Double getWinnerTotalAmount() {
		return initialNumber * factorToWin;
	}

	/**
	 * Gets the shared.
	 *
	 * @param key the key
	 * @return the shared
	 */
	private Double getShared(Integer key) {
		for (WinnerShare winnerShare : WinnerShare.values()) {
			if (winnerShare.getKey().equals(key)) {
				return winnerShare.getRate();
			}
		}
		return null;
	}

	/**
	 * Gets the winner number.
	 *
	 * @return the winner number
	 */
	public Integer getWinnerNumber() {
		return WinnerShare.values().length;
	}

	/**
	 * The Enum WinnerShare.
	 */
	private enum WinnerShare {

		/** The first. */
		FIRST(1, 0.75),

		/** The second. */
		SECOND(2, 0.15),

		/** The thrid. */
		THRID(3, 0.10);

		/** The key. */
		private Integer key;

		/**
		 * Gets the key.
		 *
		 * @return the key
		 */
		public Integer getKey() {
			return key;
		}

		/**
		 * Gets the rate.
		 *
		 * @return the rate
		 */
		public Double getRate() {
			return rate;
		}

		/** The rate. */
		private Double rate;

		/**
		 * Instantiates a new winner share.
		 *
		 * @param key
		 *            the key
		 * @param rate
		 *            the rate
		 */
		private WinnerShare(Integer key, Double rate) {
			this.key = key;
			this.rate = rate;
		}
	}
	
	/**
	 * Gets the initial number.
	 *
	 * @return the initial number
	 */
	public Integer getInitialNumber() {
		return initialNumber;
	}

	/**
	 * Gets the factor to win.
	 *
	 * @return the factor to win
	 */
	public Double getFactorToWin() {
		return factorToWin;
	}
}
