package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class PlaceBetActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public PlaceBetActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (diceGameFrame.getAddedPlayersList().getSelectedIndex() != -1) {
			// get the selected value
			String selectedId = "" + diceGameFrame.getAddedPlayersList().getSelectedValue();
			/*
			 * get the 'id' of the player the integer 'end' is set to get the last position
			 * after player's 'id' because sometimes id=1 only has 1 digit and sometimes
			 * id=10 has 2 digits
			 */
			int end = selectedId.indexOf(", Name=");

			selectedId = selectedId.substring(12, end);
			for (Player player : gameEngine.getAllPlayers()) {
				if (Integer.parseInt(player.getPlayerId()) == Integer.parseInt(selectedId)) {
					try {
						if (Integer.parseInt(diceGameFrame.getPlaceBetTextField().getText()) > 0) {
							if (Integer.parseInt(diceGameFrame.getPlaceBetTextField().getText()) <= player
									.getPoints()) {
								gameEngine.placeBet(player,
										Integer.parseInt(diceGameFrame.getPlaceBetTextField().getText()));
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
			}
		} else {
			System.out.println("please select a player when place bet");
		}
		diceGameFrame.getAddedPlayers().removeAllElements();
		for (Player player1 : gameEngine.getAllPlayers()) {
			diceGameFrame.getAddedPlayers().addElement(player1.toString() + ", Bet: " + player1.getBet());
		}
	}
}
