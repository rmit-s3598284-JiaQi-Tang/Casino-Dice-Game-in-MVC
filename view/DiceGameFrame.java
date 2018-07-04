package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.AddPlayerActionListener;
import controller.ExitActionListener;
import controller.HowToPlayActionListener;
import controller.PlaceBetActionListener;
import controller.PlaceBetForAllActionListener;
import controller.QuickAddPlayerActionListener;
import controller.RestartActionListener;
import controller.RollHouseActionListener;
import controller.RollPlayerActionListener;
import controller.RollAllPlayerActionListener;
import controller.SetDelayMenuActionListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class DiceGameFrame {
	// create the main frame
	private JFrame mainFrame;
	private JButton placeBetButton;
	private JButton placeBetForAllButton;
	private JButton rollHouseButton;
	private JButton rollPlayerButton;
	private JButton rollAllPlayerButton;
	private JButton quickAddPlayerButton;
	private JButton addPlayerButton;
	private JLabel selectPlayerReminderLabel;
	private JLabel howToSelectPlayerReminderLabel;
	private JLabel playerDiceStopReminderLabel;
	private JLabel houseDiceStopReminderLabel;
	private JTextField placeBetTextField;
	private JTextField currentPlayerDiceTextField1;
	private JTextField currentPlayerDiceTextField2;
	private JTextField currentHouseDiceTextField1;
	private JTextField currentHouseDiceTextField2;
	private JList<String> addedPlayersList;
	private JPanel controlPanel;
	private DefaultListModel<String> addedPlayers;
	private JMenuItem setDelayMenuItem;
	private JMenuItem restartMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem howToPlayItem;
	private GameEngine gameEngine = new GameEngineImpl();
	private int initialDelay;
	private int finalDelay;
	private int delayIncrement;
	private AddPlayerFrame addPlayerFrame;
	private HowToPlayFrame howToPlayFrame;
	private SetDelayFrame setDelayFrame;

	public HowToPlayFrame getHowToPlayFrame() {
		return howToPlayFrame;
	}

	public void setHowToPlayFrame(HowToPlayFrame howToPlayFrame) {
		this.howToPlayFrame = howToPlayFrame;
	}

	public SetDelayFrame getSetDelayFrame() {
		return setDelayFrame;
	}

	public void setSetDelayFrame(SetDelayFrame setDelayFrame) {
		this.setDelayFrame = setDelayFrame;
	}

	public DiceGameFrame(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	public void showDiceGameFrame() {
		mainFrame = new JFrame("Welcome to Casino Dice Game !");
		placeBetButton = new JButton("Place Bet");
		placeBetForAllButton = new JButton("Place Bet For All Players");
		rollHouseButton = new JButton("Roll House");
		rollPlayerButton = new JButton("Roll Player");
		rollAllPlayerButton = new JButton("Roll All Player");
		addPlayerButton = new JButton("Add Player");
		quickAddPlayerButton = new JButton("Quick Add Player");
		selectPlayerReminderLabel = new JLabel("Select a player to change the showing player while rolling");
		howToSelectPlayerReminderLabel = new JLabel("Now you can select a player by clicking them here");
		playerDiceStopReminderLabel = new JLabel("Players rolling complete !");
		houseDiceStopReminderLabel = new JLabel("House rolling complete !");
		placeBetTextField = new JTextField("" + 100);
		currentPlayerDiceTextField1 = new JTextField("");
		currentPlayerDiceTextField2 = new JTextField("");
		currentHouseDiceTextField1 = new JTextField("");
		currentHouseDiceTextField2 = new JTextField("");
		// set default delay, users can change them later
		initialDelay = 1;
		finalDelay = 400;
		delayIncrement = 20;

		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("| Game");
		JMenu helpMenu = new JMenu("| Help");
		setDelayMenuItem = new JMenuItem("Set Delay");
		restartMenuItem = new JMenuItem("Restart Game");
		exitMenuItem = new JMenuItem("Exit Game");
		howToPlayItem = new JMenuItem("How To Play");
		gameMenu.add(restartMenuItem);
		gameMenu.add(setDelayMenuItem);
		gameMenu.add(exitMenuItem);
		helpMenu.add(howToPlayItem);
		menuBar.setLayout(null);
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);

		addedPlayers = new DefaultListModel<String>();
		addedPlayersList = new JList<String>(addedPlayers);
		addedPlayersList.setFixedCellWidth(400);
		addedPlayersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addedPlayersList.setSelectedIndex(0);
		addedPlayersList.setVisibleRowCount(3);
		JScrollPane playerListScrollPane = new JScrollPane(addedPlayersList);

		addPlayerFrame = new AddPlayerFrame(gameEngine, addedPlayers, this);
		howToPlayFrame = new HowToPlayFrame(this);
		setDelayFrame = new SetDelayFrame(this);

		controlPanel = new JPanel();
		controlPanel.setBackground(Color.LIGHT_GRAY);
		mainFrame.setSize(850, 550);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set locations of components on panel
		playerListScrollPane.setBounds(300, 120, 470, 150);
		rollHouseButton.setBounds(300, 300, 120, 50);
		rollPlayerButton.setBounds(530, 300, 120, 50);
		rollAllPlayerButton.setBounds(650, 300, 120, 50);
		rollAllPlayerButton.setFont(new Font("Arial", Font.ITALIC, 12));
		addPlayerButton.setBounds(50, 120, 120, 40);
		quickAddPlayerButton.setBounds(170, 120, 120, 40);
		quickAddPlayerButton.setFont(new Font("Arial", Font.ITALIC, 12));
		placeBetButton.setBounds(170, 170, 120, 40);
		placeBetForAllButton.setBounds(50, 220, 240, 40);
		placeBetForAllButton.setFont(new Font("Arial", Font.ITALIC, 12));

		selectPlayerReminderLabel.setBounds(300, 100, 400, 20);
		howToSelectPlayerReminderLabel.setBounds(300, 100, 400, 20);
		playerDiceStopReminderLabel.setBounds(530, 450, 300, 20);
		houseDiceStopReminderLabel.setBounds(300, 450, 300, 20);
		placeBetTextField.setBounds(50, 170, 100, 40);
		currentPlayerDiceTextField1.setBounds(530, 350, 120, 40);
		currentPlayerDiceTextField2.setBounds(530, 400, 120, 40);
		currentHouseDiceTextField1.setBounds(300, 350, 120, 40);
		currentHouseDiceTextField2.setBounds(300, 400, 120, 40);
		gameMenu.setBounds(0, 0, 100, 20);
		helpMenu.setBounds(101, 0, 100, 20);
		menuBar.setBounds(0, 0, 201, 20);
		// link components with their own listeners
		/*
		 * because RestartActionListener need to reset the ID when quick add new players
		 * so I define a local AddPlayerActionListener which has the integer variable ID
		 * the local AddPlayerActionListener will be used when create a
		 * RestartActionListener object by constructor
		 */
		quickAddPlayerButton.addActionListener(new QuickAddPlayerActionListener(gameEngine, this));
		addPlayerButton.addActionListener(new AddPlayerActionListener(this));
		placeBetButton.addActionListener(new PlaceBetActionListener(gameEngine, this));
		placeBetForAllButton.addActionListener(new PlaceBetForAllActionListener(gameEngine, this));
		rollPlayerButton.addActionListener(new RollPlayerActionListener(gameEngine, this));
		rollAllPlayerButton.addActionListener(new RollAllPlayerActionListener(gameEngine, this));
		rollHouseButton.addActionListener(new RollHouseActionListener(gameEngine, this));
		restartMenuItem.addActionListener(new RestartActionListener(gameEngine, this));
		setDelayMenuItem.addActionListener(new SetDelayMenuActionListener(this));
		howToPlayItem.addActionListener(new HowToPlayActionListener(this));
		exitMenuItem.addActionListener(new ExitActionListener(this));
		// add components to panel
		controlPanel.setLayout(null);
		controlPanel.add(rollHouseButton);
		controlPanel.add(rollPlayerButton);
		controlPanel.add(rollAllPlayerButton);
		controlPanel.add(playerListScrollPane);
		controlPanel.add(addPlayerButton);
		controlPanel.add(quickAddPlayerButton);
		controlPanel.add(placeBetButton);
		controlPanel.add(placeBetForAllButton);
		controlPanel.add(selectPlayerReminderLabel);
		controlPanel.add(howToSelectPlayerReminderLabel);
		controlPanel.add(playerDiceStopReminderLabel);
		controlPanel.add(houseDiceStopReminderLabel);
		controlPanel.add(placeBetTextField);
		controlPanel.add(currentPlayerDiceTextField1);
		controlPanel.add(currentPlayerDiceTextField2);
		controlPanel.add(currentHouseDiceTextField1);
		controlPanel.add(currentHouseDiceTextField2);
		controlPanel.add(menuBar);
		mainFrame.add(controlPanel);
		selectPlayerReminderLabel.setVisible(false);
		howToSelectPlayerReminderLabel.setVisible(false);
		playerDiceStopReminderLabel.setVisible(false);
		houseDiceStopReminderLabel.setVisible(false);
		mainFrame.setVisible(true);
	}

	public HowToPlayFrame getHowToPlay() {
		return howToPlayFrame;
	}

	public void setHowToPlay(HowToPlayFrame howToPlay) {
		this.howToPlayFrame = howToPlay;
	}

	// getters and setters
	public JLabel getPlayerDiceStopReminderLabel() {
		return playerDiceStopReminderLabel;
	}

	public JMenuItem getHowToPlayItem() {
		return howToPlayItem;
	}

	public void setHowToPlayItem(JMenuItem howToPlayItem) {
		this.howToPlayItem = howToPlayItem;
	}

	public void setPlayerDiceStopReminderLabel(JLabel playerDiceStopReminderLabel) {
		this.playerDiceStopReminderLabel = playerDiceStopReminderLabel;
	}

	public JLabel getHouseDiceStopReminderLabel() {
		return houseDiceStopReminderLabel;
	}

	public void setHouseDiceStopReminderLabel(JLabel houseDiceStopReminderLabel) {
		this.houseDiceStopReminderLabel = houseDiceStopReminderLabel;
	}

	public void extiGame() {
		mainFrame.dispose();
	}

	public int getDelayIncrement() {
		return delayIncrement;
	}

	public void setDelayIncrement(int delayIncrement) {
		this.delayIncrement = delayIncrement;
	}

	public JMenuItem getSetDelay() {
		return exitMenuItem;
	}

	public void setSetDelay(JMenuItem setDelay) {
		this.exitMenuItem = setDelay;
	}

	public int getInitialDelay() {
		return initialDelay;
	}

	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}

	public int getFinalDelay() {
		return finalDelay;
	}

	public void setFinalDelay(int finalDelay) {
		this.finalDelay = finalDelay;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JButton getPlaceBetButton() {
		return placeBetButton;
	}

	public void setPlaceBetButton(JButton placeBetButton) {
		this.placeBetButton = placeBetButton;
	}

	public JButton getRollHouseButton() {
		return rollHouseButton;
	}

	public void setRollHouseButton(JButton rollHouseButton) {
		this.rollHouseButton = rollHouseButton;
	}

	public JButton getRollPlayerButton() {
		return rollAllPlayerButton;
	}

	public void setRollPlayerButton(JButton rollPlayerButton) {
		this.rollAllPlayerButton = rollPlayerButton;
	}

	public JButton getAddPlayerButton() {
		return quickAddPlayerButton;
	}

	public void setAddPlayerButton(JButton addPlayerButton) {
		this.quickAddPlayerButton = addPlayerButton;
	}

	public JTextField getPlaceBetTextField() {
		return placeBetTextField;
	}

	public void setPlaceBetTextField(JTextField placeBetTextField) {
		this.placeBetTextField = placeBetTextField;
	}

	public JTextField getPlayerDiceTextField1() {
		return currentPlayerDiceTextField1;
	}

	public void setPlayerDiceTextField1(JTextField playerDiceTextField1) {
		this.currentPlayerDiceTextField1 = playerDiceTextField1;
	}

	public JTextField getPlayerDiceTextField2() {
		return currentPlayerDiceTextField2;
	}

	public void setPlayerDiceTextField2(JTextField playerDiceTextField2) {
		this.currentPlayerDiceTextField2 = playerDiceTextField2;
	}

	public JTextField getHouseDiceTextField1() {
		return currentHouseDiceTextField1;
	}

	public void setHouseDiceTextField1(JTextField houseDiceTextField1) {
		this.currentHouseDiceTextField1 = houseDiceTextField1;
	}

	public JTextField getHouseDiceTextField2() {
		return currentHouseDiceTextField2;
	}

	public void setHouseDiceTextField2(JTextField houseDiceTextField2) {
		this.currentHouseDiceTextField2 = houseDiceTextField2;
	}

	public JList<String> getAddedPlayersList() {
		return addedPlayersList;
	}

	public void setAddedPlayersList(JList<String> addedPlayersList) {
		this.addedPlayersList = addedPlayersList;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public DefaultListModel<String> getAddedPlayers() {
		return addedPlayers;
	}

	public void setAddedPlayers(DefaultListModel<String> addedPlayers) {
		this.addedPlayers = addedPlayers;
	}

	public GameEngine getGameEngine() {
		return gameEngine;
	}

	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	public JLabel getSelectPlayerReminderLabel() {
		return selectPlayerReminderLabel;
	}

	public JLabel getHowToSelectPlayerReminderLabel() {
		return howToSelectPlayerReminderLabel;
	}

	public void setHowToSelectPlayerReminderLabel(JLabel howToSelectPlayerReminderLabel) {
		this.howToSelectPlayerReminderLabel = howToSelectPlayerReminderLabel;
	}

	public void setSelectPlayerReminderLabel(JLabel selectPlayerReminderLabel) {
		this.selectPlayerReminderLabel = selectPlayerReminderLabel;
	}

	public AddPlayerFrame getAddPlayerFrame() {
		return addPlayerFrame;
	}

	public void setAddPlayerFrame(AddPlayerFrame addPlayerFrame) {
		this.addPlayerFrame = addPlayerFrame;
	}

	public JButton getPlaceBetForAllButton() {
		return placeBetForAllButton;
	}

	public void setPlaceBetForAllButton(JButton placeBetForAllButton) {
		this.placeBetForAllButton = placeBetForAllButton;
	}

	public JButton getRollAllPlayerButton() {
		return rollAllPlayerButton;
	}

	public void setRollAllPlayerButton(JButton rollAllPlayerButton) {
		this.rollAllPlayerButton = rollAllPlayerButton;
	}

	public JButton getQuickAddPlayerButton() {
		return quickAddPlayerButton;
	}

	public void setQuickAddPlayerButton(JButton quickAddPlayerButton) {
		this.quickAddPlayerButton = quickAddPlayerButton;
	}

	public JTextField getCurrentPlayerDiceTextField1() {
		return currentPlayerDiceTextField1;
	}

	public void setCurrentPlayerDiceTextField1(JTextField currentPlayerDiceTextField1) {
		this.currentPlayerDiceTextField1 = currentPlayerDiceTextField1;
	}

	public JTextField getCurrentPlayerDiceTextField2() {
		return currentPlayerDiceTextField2;
	}

	public void setCurrentPlayerDiceTextField2(JTextField currentPlayerDiceTextField2) {
		this.currentPlayerDiceTextField2 = currentPlayerDiceTextField2;
	}

	public JTextField getCurrentHouseDiceTextField1() {
		return currentHouseDiceTextField1;
	}

	public void setCurrentHouseDiceTextField1(JTextField currentHouseDiceTextField1) {
		this.currentHouseDiceTextField1 = currentHouseDiceTextField1;
	}

	public JTextField getCurrentHouseDiceTextField2() {
		return currentHouseDiceTextField2;
	}

	public void setCurrentHouseDiceTextField2(JTextField currentHouseDiceTextField2) {
		this.currentHouseDiceTextField2 = currentHouseDiceTextField2;
	}

	public JMenuItem getSetDelayMenuItem() {
		return setDelayMenuItem;
	}

	public void setSetDelayMenuItem(JMenuItem setDelayMenuItem) {
		this.setDelayMenuItem = setDelayMenuItem;
	}

	public JMenuItem getRestartMenuItem() {
		return restartMenuItem;
	}

	public void setRestartMenuItem(JMenuItem restartMenuItem) {
		this.restartMenuItem = restartMenuItem;
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(JMenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}
}
