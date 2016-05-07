import java.awt.Color;

/**
 * Piece that JMan must eat (capture).
 * Has a chance to move randomly or do nothing.
 * 
 * @author Nuttapong Rojanavanich
 */
public class Walker extends Piece {
	
	/**
	 * Constructor that receive color as an integer.
	 * Chain to other constructor.
	 * 
	 * @param x is a x location of this walker.
	 * @param y is a y location of this walker.
	 * @param c is a color of this walker(Integer).
	 * @param m is a map of the game.
	 */
	public Walker(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}

	/**
	 * Constructor that receive color as an Color object.
	 * 
	 * @param x is a x location of this walker.
	 * @param y a y location of this walker.
	 * @param c is a color of this walker(Color).
	 * @param m is a map of the game
	 */
	public Walker(int x, int y, Color c, Map m) {
		super(Piece.WALKER, m);
		super.setXY(x, y);
		super.setColor(c);
	}
	
	/**
	 * Has 1/3 chance to move in random direction.
	 * 2/3 chance to do nothing.
	 */
	@Override
	public void act() {
		if (Piece.rand(1, 3) == 1) {
			int x = super.getX();
			int y = super.getY();
			Map map = super.getMap();
			int moveDirection = Piece.rand(1, 4);
			int[] newXY = moveAccordingToDirection(moveDirection);
			int newX = newXY[0];
			int newY = newXY[1];

			if (map.isInGrid(newX, newY) && map.isEmpty(newX, newY)) {
				map.move(x, y, newX, newY);
				setX(newX);
				setY(newY);
			}
		}

	}
	
	/**
	 * Return color and location of this walker.
	 */
	public String toString() {
		return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
	}
}
