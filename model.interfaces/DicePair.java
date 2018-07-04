 package model.interfaces;

/**
 * Assignment interface for SADI representing Dice values
 * 
 *  to be implemented by DicePairImpl class with the following constructor:
 * 	  public DicePairImpl(int dice1, int dice2, int numFaces)
 * 
 * NOTE: Implementation will be immutable since there are no setter methods
 * 
 * @author Caspar Ryan
 * 
 */
public interface DicePair
{
	/**
	 * @return value of dice 1 (1 .. numFaces i.e. 1 .. 6 for standard casino dice/die)
	 */
	public int getDice1();

	/**
	 * @return value of dice 2 (1 .. numFaces i.e. 1 .. 6 for standard casino die)
	 */
	public int getDice2();

	/**
	 * @return return number of faces (standard casino dice have 6) Dungeons and
	 *         Dragons dice have more!
	 */
	public int getNumFaces();

	/**
	 * 
	 * @return a human readable String that lists the values of this DicePair
	 *         instance (see OutputTrace.txt)
	 */
	@Override
	public abstract String toString();
}