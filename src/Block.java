import java.awt.Color;

/**
 * Piece that JMan can not  eat (capture), always stay still.
 * 
 * @author Nuttapong Rojanavanich
 */
public class Block extends Piece {

	/**
	 * Constructor that receive color as an integer.
	 * Chain to other constructor.
	 * 
	 * @param x is a x location of this block.
	 * @param y is a y location of this block.
	 * @param c is a color of this block(Integer).
	 * @param m is a map of the game.
	 */
	public Block(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}

	/**
	 * Constructor that receive color as a Color object.
	 * 
	 * @param x is a x location of this block.
	 * @param y a y location of this block.
	 * @param c is a color of this block(Color).
	 * @param m is a map of the game.
	 */
	public Block(int x, int y, Color c, Map m) {
		super(Piece.BLOCK, m);
		super.setXY(x, y);
		super.setColor(c);
	}
	
	/**
	 * Not used.
	 */
	@Override
	public void act() {

	}
	
	/**
	 * Return color and location of this block.
	 */
	public String toString() {
		return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
	}
}
