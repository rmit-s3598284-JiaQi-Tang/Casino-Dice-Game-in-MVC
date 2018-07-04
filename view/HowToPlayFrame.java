package view;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.OkButtonActionListener;

public class HowToPlayFrame {
	private DiceGameFrame diceGameFrame;
	private JFrame howToPlayMainFrame;
	private JPanel howToPlayPanel;
	private JButton okButton;

	public HowToPlayFrame(DiceGameFrame diceGameFrame) {
		this.diceGameFrame = diceGameFrame;
	}

	public void showHowToPlayFrame() {
		// define frame,panel,button and text fields
		howToPlayMainFrame = new JFrame("set the delay");
		howToPlayMainFrame.setSize(850, 550);
		howToPlayMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		howToPlayPanel = new JPanel();
		howToPlayPanel.setBackground(Color.LIGHT_GRAY);
		okButton = new JButton("OK");
		DefaultListModel<String> howToPlayModel = new DefaultListModel<String>();
		JList<String> howToPlayList = new JList<String>(howToPlayModel);
		howToPlayList.setFixedCellWidth(400);
		howToPlayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		howToPlayList.setSelectedIndex(0);
		howToPlayList.setVisibleRowCount(3);
		JScrollPane howToPlayScrollPane = new JScrollPane(howToPlayList);
		// explain the game rules
		howToPlayModel.addElement("==================================================================");
		howToPlayModel.addElement("Hello My User ! This is JiaQi Tang s3598284 RMIT student of SADI");
		howToPlayModel.addElement("==================================================================");
		howToPlayModel
				.addElement("This Game is quite striahtforward,It only needs several points to explain how to play");
		howToPlayModel.addElement("It only needs several steps to explain how to play my casino dice game");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("1.Add some players:");
		howToPlayModel.addElement(
				"a:you can quick add players by clicking 'Quick Add Player' ,the name will be the Roller*,initial points will be 1000");
		howToPlayModel.addElement(
				"b:you can add players by clicking 'Add Player',you can decide the name and initial points by yourself.");
		howToPlayModel.addElement("(Invalid input will be handled on console)");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("2.You can select player by clicking one of them in the list");
		howToPlayModel.addElement("");
		howToPlayModel.addElement(
				"3.You quick place the bet in the left txt field for all players by clicking 'place bet for all'");
		howToPlayModel.addElement("(Invalid input will be handled on console)");
		howToPlayModel.addElement("");
		howToPlayModel.addElement(
				"4.You can place the bet in the left txt field for the selected player by clicking 'place bet'");
		howToPlayModel.addElement("(Invalid input will be handled on console)");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("5.You can roll players by clicking 'Roll Player' button");
		howToPlayModel.addElement("(the default initial delay, final delay, delay increment are : 1, 400, 20)");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("6.You can roll house by clicking 'Roll House' button");
		howToPlayModel.addElement("(the default initial delay, final delay, delay increment are : 1, 400, 20)");
		howToPlayModel.addElement("");
		howToPlayModel.addElement(
				"7.You can set the initial delay, final delay, delay increment by clicking 'Set Delay' on the top menu");
		howToPlayModel.addElement("8.You can restart the game by clicking 'Restart Game' on the top menu");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("9.The two text fields below 'Roll Player' will show the dices of selected player ");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("10.The two text fields below 'Roll House' will show the dices of house ");
		howToPlayModel.addElement("(You can change the showing player by selecting player even during rolling)");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("11.The result of points changing will be updated after house rolling has been done");
		howToPlayModel.addElement("");
		howToPlayModel
				.addElement("12.The result will also output on console by logger, this is a multiple callback game");
		howToPlayModel.addElement("");
		howToPlayModel.addElement("13.Have fun~");
		// set bounds of frame elements
		howToPlayScrollPane.setBounds(70, 30, 700, 400);
		okButton.setBounds(350, 450, 100, 40);

		// add items
		howToPlayPanel.setLayout(null);
		howToPlayPanel.add(okButton);
		howToPlayPanel.add(howToPlayScrollPane);

		howToPlayMainFrame.add(howToPlayPanel);
		howToPlayMainFrame.setVisible(true);
		// add listener
		okButton.addActionListener(new OkButtonActionListener(diceGameFrame));
	}

	public void exit() {
		howToPlayMainFrame.dispose();
	}

}
