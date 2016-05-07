import java.awt.*;

/**
 * An instance of this class is a J*Man. There should at most one J*Man in a
 * game board at a time
 * 
 * @author Nuttapong Rojanavanich (based on Cornell university code)
 */
public class JMan extends Piece {

	/**
	 * Constructor: a new J*Man at position (x, y) on Map m with color red if c
	 * = 0, green if c = 1, and yellow if c = 2.
	 */
	public JMan(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}

	/**
	 * Constructor: a new J*Man at position (x, y) on Map m with color c.
	 * Precondition: c is one of Color.RED, Color.GREEN, and Color.YELLOW.
	 */
	public JMan(int x, int y, Color c, Map m) {
		super(Piece.JMAN, m);
		super.setXY(x, y);
		super.setColor(c);
	}

	/**
	 * J*Man should move based on what button is pushed. This method is not
	 * used.
	 */
	public void act() {
		return;
	}

	/**
	 * Move J*Man one step based on the value of i: 0 = up, 1 = down, 2 = left,
	 * 3 = right.
	 */
	public void step(int i) {
		setActed(true);
		int x = super.getX();
		int y = super.getY();
		Map map = super.getMap();
		int[] newXY = moveAccordingToDirection(i);
		int newX = newXY[0];
		int newY = newXY[1];
		if (canMove(map, newX, newY)) {
			map.move(x, y, newX, newY);
			setXY(newX, newY);
		}
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}

	/**
	 * Condition if JMan can move or not.
	 * 
	 * @param map is a map of the game.
	 * @param x is a x location that JMan is going to move to.
	 * @param y is a y location that JMan is going to move to.
	 * @return true if JMan can move, false if JMan can not move.
	 */
	public boolean canMove(Map map, int x, int y) {
		return map.isInGrid(x, y)
				&& (map.isEmpty(x, y) || (map.pieceAt(x, y).getType() != Piece.BLOCK && canEat(map, x, y)));
	}

	/**
	 * Check if JMan cat eat piece on the next grind or not. If JMan can eat,
	 * change the color of JMan to be the color of eaten piece.
	 * 
	 * @param map is a map of the game.
	 * @param x is a x location that JMan is going to move to.
	 * @param y is a y location that JMan is going to move to.
	 * @return true if JMan can eat, false if JMan can not eat.
	 */
	public boolean canEat(Map map, int x, int y) {
		if (checkColorMatch(map, x, y)) {
			super.setColor(map.pieceAt(x, y).getColor());
			return true;
		}
		return false;
	}

	/**
	 * Check if JMan can eat piece according to color condition or not.
	 * 
	 * @param map is a map of the game.
	 * @param x is a x location that JMan is going to move to.
	 * @param y is a y location that JMan is going to move to.
	 * @return true if JManColor match the eat condition, false if not.
	 */
	public boolean checkColorMatch(Map map, int x, int y) {
		Color JManColor = super.getColor();
		Color nextGridPieceColor = map.grid[x][y].getColor();
		return canEatAccordingToColor(JManColor, nextGridPieceColor, Color.GREEN, Color.RED)
				|| canEatAccordingToColor(JManColor, nextGridPieceColor, Color.RED, Color.YELLOW)
				|| canEatAccordingToColor(JManColor, nextGridPieceColor, Color.YELLOW, Color.GREEN);
	}

	/**
	 * Check if JMan color and piece on the next grid match the color in the
	 * condition or not.
	 * 
	 * @param JManColor is the color of JMan.
	 * @param nextGridPieceColor is the color of piece on the next grid.
	 * @param conditionColor1 is the condition color for JMan.
	 * @param conditionColor2 is the condition color for piece on the next grid.
	 * @return true if JMan and the piece color match the color condition, false if not.
	 */
	public boolean canEatAccordingToColor(Color JManColor, Color nextGridPieceColor, Color conditionColor1,
			Color conditionColor2) {
		return JManColor.equals(conditionColor1) && nextGridPieceColor.equals(conditionColor2);
	}
}
