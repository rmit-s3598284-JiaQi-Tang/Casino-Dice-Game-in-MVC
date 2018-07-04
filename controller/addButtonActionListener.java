package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimplePlayer;
import model.interfaces.Player;
import view.AddPlayerFrame;

public class addButtonActionListener implements ActionListener {
	private AddPlayerFrame addPlayerFrame;

	public addButtonActionListener(AddPlayerFrame addPlayerFrame) {
		super();
		this.addPlayerFrame = addPlayerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// clear all the elements everytime when the playerList updated
		addPlayerFrame.getAddedPlayers().removeAllElements();
		int newPlayerID = addPlayerFrame.getGameEngine().getAllPlayers().size() + 1;
		try {
			addPlayerFrame.getGameEngine().addPlayer(
					new SimplePlayer(Integer.toString(newPlayerID), addPlayerFrame.getNameTextField().getText(),
							Integer.parseInt(addPlayerFrame.getInitialPointsTextField().getText())));
			for (Player player : addPlayerFrame.getGameEngine().getAllPlayers()) {
				addPlayerFrame.getAddedPlayers().addElement(player.toString() + ", Bet: " + player.getBet());
			}
			addPlayerFrame.exit();
			addPlayerFrame.getDiceGameFrame().getHowToSelectPlayerReminderLabel().setVisible(true);
			System.out.println("a new player added successfully");
		} catch (NumberFormatException e1) {
			System.out.println("the initial points should be a integer");
		}
	}

}
