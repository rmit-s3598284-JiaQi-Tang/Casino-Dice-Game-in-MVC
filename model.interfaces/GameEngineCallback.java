package model.interfaces;

/**
 * Assignment interface for SADI to notify client of GameEngine events for display/logging e.g.
 * ongoing dice roll, final roll result for both players and house
 * 
 * @author Caspar Ryan
 * 
 */
public interface GameEngineCallback
{
	/**
	 * called as the dice are rolling for a Player, use this to update your
	 * display or log to console
	 * 
	 * @param player
	 *            the Player who rolled
	 * @param dicePair
	 *            the current (upfacing) values of the rolling dice
	 * @param gameEngine
	 *            a convenience reference to the engine so the receiver can call
	 *            methods if necessary
	 * @see model.interfaces.GameEngine
	 */
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine);

	/**
	 * 
	 * called when dice have stopped rolling with the final resting dice values
	 * 
	 * @param player
	 *            the Player who rolled
	 * @param result
	 *            the final resting state of the rolled dice
	 * @param gameEngine
	 *            a convenience reference to the engine so the receiver can call
	 *            methods if necessary
	 * @see model.interfaces.GameEngine
	 */
	public void result(Player player, DicePair result, GameEngine gameEngine);

	/**
	 * called as the HOUSE dice are rolling, use this to update your display or
	 * log to console
	 * 
	 * @param dicePair
	 *            the current (upfacing) values of the rolling dice
	 * @param gameEngine
	 *            a convenience reference to the engine so the receiver can call
	 *            methods if necessary
	 * @see model.interfaces.GameEngine
	 */
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine);

	/**
	 * 
	 * called when HOUSE dice have stopped rolling with the final resting dice values
	 * 
	 * PRE-CONDITION: This method should only be called after bets have been updated on all Players 
	 * so this callback can log Player results
	 * 
	 * @param result
	 *            the final resting state of the rolled dice
	 * @param gameEngine
	 *            a convenience reference to the engine so the receiver can call
	 *            methods if necessary
	 * @see model.interfaces.GameEngine
	 */
	public void houseResult(DicePair result, GameEngine gameEngine);
}
