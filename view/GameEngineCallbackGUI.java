package view;

import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback {
	private GameEngine gameEngine = new GameEngineImpl();
	private DiceGameFrame diceGameFrame = new DiceGameFrame(gameEngine);

	public GameEngineCallbackGUI(DiceGameFrame diceGameFrame, GameEngine gameEngine) {
		this.diceGameFrame = diceGameFrame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void intermediateResult(final Player player, DicePair dicePair, final GameEngine gameEngine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				diceGameFrame.getPlayerDiceStopReminderLabel().setVisible(false);
				if (diceGameFrame.getAddedPlayersList().getSelectedIndex() != -1) {
					diceGameFrame.getSelectPlayerReminderLabel().setVisible(false);
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
								diceGameFrame.getPlayerDiceTextField1()
										.setText(player.getPlayerName() + " : " + player.getRollResult().getDice1());
								diceGameFrame.getPlayerDiceTextField2()
										.setText(player.getPlayerName() + " : " + player.getRollResult().getDice2());
							} catch (NullPointerException e) {
							}

						}
					}
				} else {
					diceGameFrame.getHowToSelectPlayerReminderLabel().setVisible(false);
					diceGameFrame.getSelectPlayerReminderLabel().setVisible(true);
					diceGameFrame.getPlayerDiceTextField1()
							.setText(player.getPlayerName() + " : " + player.getRollResult().getDice1());
					diceGameFrame.getPlayerDiceTextField2()
							.setText(player.getPlayerName() + " : " + player.getRollResult().getDice2());
				}
			}
		});
	}

	@Override
	public void result(final Player player, DicePair resultDicePair, GameEngine gameEngine) {
		diceGameFrame.getPlayerDiceStopReminderLabel().setVisible(true);
	}

	@Override
	public void intermediateHouseResult(final DicePair dicePair, GameEngine gameEngine) {
		diceGameFrame.getHouseDiceStopReminderLabel().setVisible(false);
		diceGameFrame.getHouseDiceTextField1().setText("House : " + dicePair.getDice1());
		diceGameFrame.getHouseDiceTextField2().setText("House : " + dicePair.getDice2());
	}

	@Override
	public void houseResult(final DicePair result, GameEngine gameEngine) {
		diceGameFrame.getHouseDiceStopReminderLabel().setVisible(true);
	}

}
