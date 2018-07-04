package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class RollHouseActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public RollHouseActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.diceGameFrame = diceGameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread() {
			@Override
			public void run() {
				try {
					gameEngine.rollHouse(diceGameFrame.getInitialDelay(), diceGameFrame.getFinalDelay(),
							diceGameFrame.getDelayIncrement());
					// after the house rolled, update all players points changing
					diceGameFrame.getAddedPlayers().removeAllElements();
					for (Player player : gameEngine.getAllPlayers()) {
						player.placeBet(0);
						int total = player.getRollResult().getDice1() + player.getRollResult().getDice2();
						diceGameFrame.getAddedPlayers().addElement(
								player.toString() + ", Bet: " + player.getBet() + ", latest result: " + total);
					}
				} catch (NullPointerException e1) {
					System.out.println("the players didn't rolled yet!");
				}
			}
		}.start();

	}
}
