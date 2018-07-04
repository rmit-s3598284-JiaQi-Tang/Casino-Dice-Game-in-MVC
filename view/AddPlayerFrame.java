package view;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.addButtonActionListener;
import model.interfaces.GameEngine;

public class AddPlayerFrame {
	private GameEngine gameEngine;
	private DefaultListModel<String> addedPlayers;
	private DiceGameFrame diceGameFrame;
	private JFrame addPlayerMainFrame;
	private JPanel addPlayerPanel;
	private JButton addButton;
	private JTextField nameTextField;
	private JTextField initialPointsTextField;

	public AddPlayerFrame(GameEngine gameEngine, DefaultListModel<String> addedPlayers, DiceGameFrame diceGameFrame) {
		this.gameEngine = gameEngine;
		this.addedPlayers = addedPlayers;
		this.diceGameFrame = diceGameFrame;
	}

	public void showAddPlayerFrame() {
		// define frame,panel,button and text fields
		addPlayerMainFrame = new JFrame("add a new player");
		addPlayerMainFrame.setSize(850, 550);
		addPlayerMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addPlayerPanel = new JPanel();
		addPlayerPanel.setBackground(Color.LIGHT_GRAY);
		addButton = new JButton("Add");
		nameTextField = new JTextField("Name");
		initialPointsTextField = new JTextField("Initial Points");
		// set bounds of frame elements
		addButton.setBounds(170, 40, 120, 40);
		nameTextField.setBounds(300, 40, 120, 40);
		initialPointsTextField.setBounds(450, 40, 120, 40);
		// add items
		addPlayerPanel.setLayout(null);
		addPlayerPanel.add(addButton);
		addPlayerPanel.add(nameTextField);
		addPlayerPanel.add(initialPointsTextField);
		addPlayerMainFrame.add(addPlayerPanel);
		addPlayerMainFrame.setVisible(true);
		// add listener
		addButton.addActionListener(new addButtonActionListener(this));
	}

	public void exit() {
		addPlayerMainFrame.dispose();
	}

	public GameEngine getGameEngine() {
		return gameEngine;
	}

	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	public DefaultListModel<String> getAddedPlayers() {
		return addedPlayers;
	}

	public void setAddedPlayers(DefaultListModel<String> addedPlayers) {
		this.addedPlayers = addedPlayers;
	}

	public DiceGameFrame getDiceGameFrame() {
		return diceGameFrame;
	}

	public void setDiceGameFrame(DiceGameFrame diceGameFrame) {
		this.diceGameFrame = diceGameFrame;
	}

	public JFrame getAddPlayerMainFrame() {
		return addPlayerMainFrame;
	}

	public void setAddPlayerMainFrame(JFrame addPlayerMainFrame) {
		this.addPlayerMainFrame = addPlayerMainFrame;
	}

	public JPanel getAddPlayerPanel() {
		return addPlayerPanel;
	}

	public void setAddPlayerPanel(JPanel addPlayerPanel) {
		this.addPlayerPanel = addPlayerPanel;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JTextField getInitialPointsTextField() {
		return initialPointsTextField;
	}

	public void setInitialPointsTextField(JTextField initialPointsTextField) {
		this.initialPointsTextField = initialPointsTextField;
	}

}
