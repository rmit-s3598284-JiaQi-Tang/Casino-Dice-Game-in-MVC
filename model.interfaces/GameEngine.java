package model.interfaces;

import java.util.Collection;

/**
 * Assignment interface for SADI providing main Dice Game model functionality s1
 * 2018
 * 
 * @author Caspar Ryan
 * 
 */
public interface GameEngine
{
	/**
	 * set the default size of the dice (Casino style!)
	 */
	public static int NUM_FACES = 6;

	/**
	 * the implementation should forward the call to the player class so the bet is set per player
	 * @see Player#placeBet(int)
	 * 
	 * @param player
	 *            the player who is placing the bet
	 * @param bet
	 *            the bet in points
	 * @return true if the player had sufficient points and the bet was placed
	 */
	public abstract boolean placeBet(Player player, int bet);

	/**
	 * roll the dice progressing from the initialDelay to the finalDelay in
	 * increments of delayIncrement, delays are in milliseconds (ms)
	 * 
	 * 1. start at initialDelay then increment the delay each time a new number
	 *    is shown on the die faces 
	 * 2. call GameEngineCallback.intermediateResult(...) or intermediateHouseResult(...) each time 
	 *    a pair of new dice faces are shown until delay greater than or equal to finalDelay 
	 * 3. call GameEngineCallback.result(...) or houseResult(...) with final result for player or house 
	 * 4. make sure you update the player with final result so it can be retreived later
	 * 
	 * @param player
	 *            the player who is rolling and will have their result set
	 *            at the end of the roll
	 * @param initialDelay
	 *            the starting delay in ms between updates (based on how fast
	 *            dice are rolling)
	 * @param finalDelay
	 *            the final delay in ms between updates when the dice stop
	 *            rolling
	 * @param delayIncrement
	 *            how much the dice slow down (delay gets longer) after each
	 *            roll/tumble
	 * 
	 * @see model.interfaces.GameEngineCallback
	 * 
	 */
	public abstract void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement);

	/**
	 * Same as rollPlayer() but rolls for the house and calls the house versions
	 * of the callback methods on GameEngineCallback, no player parameter is required. 
	 * 
	 * All bets are settled at the end of this method i.e. this method goes through all players 
	 * and applies win or loss to update betting points 
	 * (this functionality should be implemented in a separate private method in GameEngineImpl)
	 * 
	 * @param initialDelay same as rollPlayer()
	 * @param finalDelay same as rollPlayer()
	 * @param delayIncrement same as rollPlayer()
	 * 
	 * @see GameEngine#rollPlayer(Player, int, int, int)
	 */
	public abstract void rollHouse(int initialDelay, int finalDelay, int delayIncrement);

	/**
	 * @param player
	 *            to add to game
	 */
	public abstract void addPlayer(Player player);

	/**
	 * @param id
	 *            id of player to retrieve
	 * @return the corresponding Player instance or null if Player doesn't exist
	 */
	public abstract Player getPlayer(String id);

	/**
	 * @param player
	 *            to remove from game
	 * @return true if the player existed
	 */
	public abstract boolean removePlayer(Player player);

	/**
	 * @param gameEngineCallback
	 *            a client specific implementation of GameEngineCallback used to
	 *            perform display updates/logging
	 * 
	 *            you will write a different implementation for console and GUI
	 *            implementations (Assignments part 1 and 2)
	 */
	public abstract void addGameEngineCallback(GameEngineCallback gameEngineCallback);

	/**
	 * @param gameEngineCallback
	 *            called when a player quits the game to remove no longer needed
	 *            UI updates
	 * @return true if the gameEngineCallback existed
	 */
	public abstract boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback);

	/**
	 * 
	 * @return an unmodifiable collection of all Players
	 * @see model.interfaces.Player
	 */
	public abstract Collection<Player> getAllPlayers();
}