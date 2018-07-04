package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DiceGameFrame;

public class AddPlayerActionListener implements ActionListener {
	private DiceGameFrame diceGameFrame;

	public AddPlayerActionListener(DiceGameFrame diceGameFrame) {
		this.diceGameFrame = diceGameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		diceGameFrame.getAddPlayerFrame().showAddPlayerFrame();
	}

}
