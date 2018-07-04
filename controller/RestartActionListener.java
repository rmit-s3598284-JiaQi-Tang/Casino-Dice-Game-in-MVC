package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class RestartActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public RestartActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.diceGameFrame = diceGameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		diceGameFrame.getPlayerDiceStopReminderLabel().setVisible(false);
		diceGameFrame.getHouseDiceStopReminderLabel().setVisible(false);
		diceGameFrame.getSelectPlayerReminderLabel().setVisible(false);
		diceGameFrame.getHowToSelectPlayerReminderLabel().setVisible(false);
		diceGameFrame.getPlaceBetTextField().setText("");
		diceGameFrame.getPlayerDiceTextField1().setText("");
		diceGameFrame.getPlayerDiceTextField2().setText("");
		diceGameFrame.getHouseDiceTextField1().setText("");
		diceGameFrame.getHouseDiceTextField2().setText("");
		gameEngine.getAllPlayers().clear();
		diceGameFrame.getAddedPlayers().removeAllElements();
		for (Player player1 : gameEngine.getAllPlayers()) {
			diceGameFrame.getAddedPlayers().addElement(player1.toString() + ", Bet: " + player1.getBet());
		}
	}
}