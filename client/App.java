package client;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.DiceGameFrame;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class App {

	public static void main(String args[]) {
		GameEngine gameEngine = new GameEngineImpl();
		DiceGameFrame diceGameFrame = new DiceGameFrame(gameEngine);
		// add mutiple callbacks
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(diceGameFrame, gameEngine));
		// run the show GUI method
		diceGameFrame.showDiceGameFrame();
	}
}
