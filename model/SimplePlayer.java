package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int initialPoints;
	private int bet;
	private DicePair rollResult;

	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;

	}

	@Override
	public int getPoints() {
		return initialPoints;
	}

	@Override
	public void setPoints(int points) {
		this.initialPoints = points;

	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean placeBet(int bet) {
		if (bet > initialPoints) {
			return false;
		} else
			this.bet = bet;
		return true;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public DicePair getRollResult() {
		return this.rollResult;
	}

	@Override
	public void setRollResult(DicePair rollResult) {
		this.rollResult = rollResult;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Player: id=" + playerId);
		sb.append(", Name=" + playerName);
		sb.append(", points=: " + initialPoints);
		return sb.toString();
	}
}
