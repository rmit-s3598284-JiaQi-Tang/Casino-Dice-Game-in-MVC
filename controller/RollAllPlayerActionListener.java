package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class RollAllPlayerActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public RollAllPlayerActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.diceGameFrame = diceGameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (final Player player : gameEngine.getAllPlayers()) {
			new Thread() {
				@Override
				public void run() {
					if (player.getPoints() > 0) {
						if (player.getBet() != 0) {
							gameEngine.rollPlayer(player, diceGameFrame.getInitialDelay(),
									diceGameFrame.getFinalDelay(), diceGameFrame.getDelayIncrement());
						} else {
							System.out.println(player.getPlayerName() + " did not place bet");
						}
					} else {
						System.out.println(player.getPlayerName() + " does not have enough points to keep gambling");
					}
				}
			}.start();
		}
	}
}
