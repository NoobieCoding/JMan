import java.awt.Color;

/**
 * Piece that JMan must eat (capture). 
 * Has a chance to change color (red, green or yellow).
 * 
 * @author Nuttapong Rojanavanich
 */
public class Pillar extends Piece {

	/**
	 * Constructor that receive color as an integer.
	 * Chain to other constructor.
	 * 
	 * @param x is a x location of this pillar.
	 * @param y is a y location of this pillar.
	 * @param c is a color of this pillar(Integer).
	 * @param m is a map of the game.
	 */
	public Pillar(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}
	
	/**
	 * Constructor that receive color as a Color object.
	 * 
	 * @param x is a x location of this pillar.
	 * @param y a y location of this pillar.
	 * @param c is a color of this pillar(Color).
	 * @param m is a map of the game.
	 */
	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		super.setXY(x, y);
		super.setColor(c);
	}
	
	/**
	 * Has 1/3 chance to change color between red, green, and yellow.
	 * 2/3 chance to do nothing.
	 */
	@Override
	public void act() {
		if (Piece.rand(1, 3) == 1)
			super.setColor(determineColor(rand(0, 2)));
	}
	
	/**
	 * Return color and location of this pillar.
	 */
	public String toString() {
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}
}
