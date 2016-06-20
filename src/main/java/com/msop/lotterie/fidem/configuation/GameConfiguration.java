package com.msop.lotterie.fidem.configuation;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class GameConfiguration.
 */
public final class GameConfiguration {

	/** The Constant INITIAL_NUMBER. */
	public static final Integer INITIAL_NUMBER = 200;
	
	/** The Constant MAX_COMMAND_PER_GAME. */
	public static final Integer MAX_COMMAND_PER_GAME = 100;

	/** The Constant FACTOR. */
	private static final Double FACTOR = 0.5;

	/**
	 * Instantiates a new game configuration.
	 */
	private GameConfiguration() {
	}
	/**
	 * Inits the available number.
	 *
	 * @return the list
	 */
	public static List<Integer> initAvailableNumber() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < INITIAL_NUMBER; i++) {
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
	public static Integer getSharedAmount(Integer key) {
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
	public static Double getWinnerTotalAmount() {
		return INITIAL_NUMBER * FACTOR;
	}

	/**
	 * Gets the shared.
	 *
	 * @param key the key
	 * @return the shared
	 */
	private static Double getShared(Integer key) {
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
	public static Integer getWinnerNumber() {
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
		 * @param key the key
		 * @param rate the rate
		 */
		private WinnerShare(Integer key, Double rate) {
			this.key = key;
			this.rate = rate;
		}
	}
}
