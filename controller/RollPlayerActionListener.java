package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;

public class RollPlayerActionListener implements ActionListener {
	private GameEngine gameEngine;
	private DiceGameFrame diceGameFrame;

	public RollPlayerActionListener(GameEngine gameEngine, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.diceGameFrame = diceGameFrame;
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
			for (final Player player : gameEngine.getAllPlayers()) {
				if (Integer.parseInt(player.getPlayerId()) == Integer.parseInt(selectedId)) {

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
								System.out.println(
										player.getPlayerName() + " does not have enough points to keep gambling");
							}
						}
					}.start();

				}
			}
		} else {
			System.out.println("please select a player when rolll player");
		}

	}
}
