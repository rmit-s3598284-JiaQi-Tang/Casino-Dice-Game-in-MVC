package model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine {
	private final Collection<Player> playerList = new ArrayList<Player>();
	private final Collection<GameEngineCallback> gameEngineCallbackList = new ArrayList<GameEngineCallback>();

	@Override
	public boolean placeBet(Player player, int bet) {
		player.placeBet(bet);
		boolean i = player.placeBet(bet);
		return i;
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		DicePair rollResult = null;
		for (int rollTimes = initialDelay; rollTimes < finalDelay; rollTimes = rollTimes + delayIncrement) {
			rollResult = new DicePairImpl((int) (1 + Math.random() * NUM_FACES), (int) (1 + Math.random() * NUM_FACES),
					NUM_FACES);
			player.setRollResult(rollResult);
			for (GameEngineCallback gameEngineCallback : gameEngineCallbackList) {
				gameEngineCallback.intermediateResult(player, rollResult, this);
			}
			try {
				Thread.sleep(rollTimes);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (GameEngineCallback gameEngineCallback : gameEngineCallbackList) {
			gameEngineCallback.result(player, rollResult, this);
		}
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		DicePair rollResult = null;
		for (int rollTimes = initialDelay; rollTimes < finalDelay; rollTimes = rollTimes + delayIncrement) {

			rollResult = new DicePairImpl((int) (1 + Math.random() * NUM_FACES), (int) (1 + Math.random() * NUM_FACES),
					NUM_FACES);
			for (GameEngineCallback gameEngineCallback : gameEngineCallbackList) {
				gameEngineCallback.intermediateHouseResult(rollResult, this);
			}
			try {
				Thread.sleep(rollTimes);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (Player player : playerList) {
			if (player.getRollResult().getDice1() + player.getRollResult().getDice2() > rollResult.getDice1()
					+ rollResult.getDice2()) {
				player.setPoints(player.getPoints() + player.getBet());
			}
			if (player.getRollResult().getDice1() + player.getRollResult().getDice2() == rollResult.getDice1()
					+ rollResult.getDice2()) {
				player.setPoints(player.getPoints());
			}
			if (player.getRollResult().getDice1() + player.getRollResult().getDice2() < rollResult.getDice1()
					+ rollResult.getDice2()) {
				player.setPoints(player.getPoints() - player.getBet());
			}
		}
		for (GameEngineCallback gameEngineCallback : gameEngineCallbackList) {
			gameEngineCallback.houseResult(rollResult, this);
		}
	}

	@Override
	public void addPlayer(Player player) {
		playerList.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player player : playerList) {
			if (player.getPlayerId() == id) {
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		return playerList.remove(player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbackList.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return gameEngineCallbackList.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return playerList;
	}
}
