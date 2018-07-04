package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class PlaceBetForAllActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public PlaceBetForAllActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.diceGameFrame = diceGameFrame;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Player player : gameEngine.getAllPlayers()) {
			try {
				if (Integer.parseInt(diceGameFrame.getPlaceBetTextField().getText()) > 0) {
					if (Integer.parseInt(diceGameFrame.getPlaceBetTextField().getText()) <= player.getPoints()) {
						gameEngine.placeBet(player, Integer.parseInt(diceGameFrame.getPlaceBetTextField().getText()));
						System.out.println(player.getPlayerName() + " place bet successfully");
					} else {
						System.out.println(player.getPlayerName() + " does not have enough points !");
					}
				} else {
					System.out.println("the bet can not be negative or zero !");
				}
			} catch (NumberFormatException e1) {
				System.out.println("the bet should be an integer");
			}
		}
		diceGameFrame.getAddedPlayers().removeAllElements();
		for (Player player1 : gameEngine.getAllPlayers()) {
			diceGameFrame.getAddedPlayers().addElement(player1.toString() + ", Bet: " + player1.getBet());
		}
	}
}
