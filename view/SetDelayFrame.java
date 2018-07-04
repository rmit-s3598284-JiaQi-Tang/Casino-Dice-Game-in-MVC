package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.SetDelayButtonActionListener;

public class SetDelayFrame {
	private DiceGameFrame diceGameFrame;
	private JFrame setDelayMainFrame;
	private JPanel setDelayPanel;
	private JButton setDelayButton;
	private JTextField initialDelayTextField;
	private JTextField finalDelayTextField;
	private JTextField delayIncrementTextField;

	public SetDelayFrame(DiceGameFrame diceGameFrame) {
		this.diceGameFrame = diceGameFrame;
	}

	public void showSetDelayFrame() {
		// define frame,panel,button and text fields
		setDelayMainFrame = new JFrame("set the delay");
		setDelayMainFrame.setSize(850, 550);
		setDelayMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDelayPanel = new JPanel();
		setDelayPanel.setBackground(Color.LIGHT_GRAY);
		setDelayButton = new JButton("Set Delay");
		initialDelayTextField = new JTextField("" + 1);
		finalDelayTextField = new JTextField("" + 800);
		delayIncrementTextField = new JTextField("" + 20);
		// set bounds of frame elements
		setDelayButton.setBounds(170, 40, 120, 40);
		initialDelayTextField.setBounds(300, 40, 120, 40);
		finalDelayTextField.setBounds(450, 40, 120, 40);
		delayIncrementTextField.setBounds(600, 40, 120, 40);
		// add items
		setDelayPanel.setLayout(null);
		setDelayPanel.add(setDelayButton);
		setDelayPanel.add(initialDelayTextField);
		setDelayPanel.add(finalDelayTextField);
		setDelayPanel.add(delayIncrementTextField);
		setDelayMainFrame.add(setDelayPanel);
		setDelayMainFrame.setVisible(true);
		// add listener
		setDelayButton.addActionListener(new SetDelayButtonActionListener(this));
	}

	public DiceGameFrame getDiceGameFrame() {
		return diceGameFrame;
	}

	public void setDiceGameFrame(DiceGameFrame diceGameFrame) {
		this.diceGameFrame = diceGameFrame;
	}

	public JFrame getSetDelayMainFrame() {
		return setDelayMainFrame;
	}

	public void setSetDelayMainFrame(JFrame setDelayMainFrame) {
		this.setDelayMainFrame = setDelayMainFrame;
	}

	public JPanel getSetDelayPanel() {
		return setDelayPanel;
	}

	public void setSetDelayPanel(JPanel setDelayPanel) {
		this.setDelayPanel = setDelayPanel;
	}

	public JButton getSetDelayButton() {
		return setDelayButton;
	}

	public void setSetDelayButton(JButton setDelayButton) {
		this.setDelayButton = setDelayButton;
	}

	public JTextField getInitialDelayTextField() {
		return initialDelayTextField;
	}

	public void setInitialDelayTextField(JTextField initialDelayTextField) {
		this.initialDelayTextField = initialDelayTextField;
	}

	public JTextField getFinalDelayTextField() {
		return finalDelayTextField;
	}

	public void setFinalDelayTextField(JTextField finalDelayTextField) {
		this.finalDelayTextField = finalDelayTextField;
	}

	public JTextField getDelayIncrementTextField() {
		return delayIncrementTextField;
	}

	public void setDelayIncrementTextField(JTextField delayIncrementTextField) {
		this.delayIncrementTextField = delayIncrementTextField;
	}

	public void exit() {
		setDelayMainFrame.dispose();
	}

}
