package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class QuickAddPlayerActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public QuickAddPlayerActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.diceGameFrame = diceGameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// clear all the elements everytime when the playerList updated
		diceGameFrame.getAddedPlayers().removeAllElements();
		int newPlayerID = gameEngine.getAllPlayers().size() + 1;
		gameEngine.addPlayer(new SimplePlayer(Integer.toString(newPlayerID), "The Roller" + newPlayerID, 1000));
		System.out.println("a new player added successfully");
		for (Player player : gameEngine.getAllPlayers()) {
			diceGameFrame.getAddedPlayers().addElement(player.toString() + ", Bet: " + player.getBet());
		}
		diceGameFrame.getHowToSelectPlayerReminderLabel().setVisible(true);
	}
}
