package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging
 * behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl() {
		logger.setLevel(Level.FINE);
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		Logger log1 = Logger.getLogger("assignment1");
		log1.fine(player.getPlayerName() + ": ROLLING " + dicePair.toString());
	}

	@Override
	public void result(Player player, DicePair resultDicePair, GameEngine gameEngine) {

		Logger log2 = Logger.getLogger("assignment1");
		log2.info(player.getPlayerName() + ": *RESULT* " + resultDicePair.toString());
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {

		Logger log3 = Logger.getLogger("assignment1");
		log3.fine(":House: ROLLING " + dicePair.toString());
	}

	@Override
	public void houseResult(DicePair resultDicePair, GameEngine gameEngine) {

		Logger log4 = Logger.getLogger("assignment1");
		log4.info(":House: *RESULT* " + resultDicePair.toString());
		Logger log5 = Logger.getLogger("assignment1");
		for (Player player : gameEngine.getAllPlayers()) {
			log5.info(player.toString());
		}
	}
}
