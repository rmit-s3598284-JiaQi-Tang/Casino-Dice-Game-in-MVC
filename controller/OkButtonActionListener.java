package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DiceGameFrame;

public class OkButtonActionListener implements ActionListener {
	private DiceGameFrame diceGameFrame;

	public OkButtonActionListener(DiceGameFrame diceGameFrame) {
		this.diceGameFrame = diceGameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		diceGameFrame.getHowToPlay().exit();

	}

}
