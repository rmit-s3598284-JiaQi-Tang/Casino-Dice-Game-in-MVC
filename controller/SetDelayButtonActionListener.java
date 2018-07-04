package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.SetDelayFrame;

public class SetDelayButtonActionListener implements ActionListener {
	private SetDelayFrame setDelayFrame;

	public SetDelayButtonActionListener(SetDelayFrame setDelayFrame) {
		this.setDelayFrame = setDelayFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			setDelayFrame.getDiceGameFrame()
					.setInitialDelay(Integer.parseInt(setDelayFrame.getInitialDelayTextField().getText()));
			setDelayFrame.getDiceGameFrame()
					.setFinalDelay(Integer.parseInt(setDelayFrame.getFinalDelayTextField().getText()));
			setDelayFrame.getDiceGameFrame()
					.setDelayIncrement(Integer.parseInt(setDelayFrame.getDelayIncrementTextField().getText()));
			setDelayFrame.exit();
		} catch (NumberFormatException e) {
			System.out.println("please input integer only");
		}
	}

}
