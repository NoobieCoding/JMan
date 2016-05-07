import java.awt.*;

/**
 * An instance is a piece for use in the J*Man!!
 * 
 * @author Nuttapong Rojanavanich (based on Cornell university code)
 */
public abstract class Piece {
	/** Constants that identify the kind of a piece. */
	public static final int BLOCK = 0; // piece is a block
	public static final int JMAN = 1; // piece is the J*man
	public static final int WALKER = 2; // piece is a walker
	public static final int PILLAR = 3; // piece is a pillar

	private int x, y, type;
	private Map map;
	private Color color;
	private boolean acted;

	/**
	 * Constructor: a Piece on Map m with type t. Precondition: type is one of
	 * the four constants of this class.
	 */
	public Piece(int t, Map m) {
		type = t;
		map = m;
		acted = false;
	}

	/** = this piece's type: (one of the four constants of this class. */
	public int getType() {
		return type;
	}

	/** = this piece's x location. */
	public int getX() {
		return x;
	}

	/** = this piece's y location. */
	public int getY() {
		return y;
	}

	/** = this piece's color. */
	public Color getColor() {
		return color;
	}

	/**
	 * = the color of this piece, as a capitalized word (e.g. "Red"). = the
	 * empty string if it is not one of red, green, yellow, or white
	 */
	public String getColorWord() {
		if (color.equals(Color.RED))
			return "Red";
		else if (color.equals(Color.GREEN))
			return "Green";
		else if (color.equals(Color.YELLOW))
			return "Yellow";
		else if (color.equals(Color.WHITE))
			return "White";

		return "";
	}

	/** = "This piece has already acted this round". */
	public boolean hasActed() {
		return acted;
	}

	/** = the map this piece is on. */
	public Map getMap() {
		return map;
	}

	/** Set this piece's x location to x. */
	public void setX(int x) {
		this.x = x;
	}

	/** Set this piece's y location to y. */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Set this piece's color to the c. Precondition: c is Color.WHITE and this
	 * is a block,OR c is Color.RED, Color.GREEN, or Color.YELLOW.
	 */
	public void setColor(Color c) {
		color = c;
	}

	/** Set the state of this piece to the value of acted. */
	public void setActed(boolean acted) {
		this.acted = acted;
	}

	/**
	 * Make this piece take one action.
	 */
	public abstract void act();

	/**
	 * = a random integer in the range lo..hi, with all integers in the range
	 * being equally likely. Precondition lo < hi.
	 */
	public static int rand(int lo, int hi) {
		return (int) (Math.random() * (hi - lo + 1)) + lo;
	}

	/**
	 * Determine the color from integer condition: c = 0, color = red, c = 1,
	 * color = green, c = 2, color = yellow.
	 * 
	 * @param c is a integer that represents specific color.
	 * @return Color (has Color as a data type).
	 */
	public static Color determineColor(int c) {
		if (c == 0)
			return Color.RED;
		else if (c == 1)
			return Color.GREEN;
		else
			return Color.YELLOW;
	}

	/**
	 * Set this piece's x and y location
	 * 
	 * @param x is the x location to be set.
	 * @param y is the y location to be set.
	 */
	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}

	/**
	 * Determine the direction to move from specific integer: moveDirection = 0,
	 * move up, moveDirection = 1, move down, moveDirection = 2, move left,
	 * moveDirection = 3, move right,
	 * 
	 * @param moveDirection is a specific integer for each direction to move.
	 * @return New x and y location.
	 */
	public int[] moveAccordingToDirection(int moveDirection) {
		int newY = y;
		int newX = x;
		if (moveDirection == 0)
			newY = y - 1;
		else if (moveDirection == 1)
			newY = y + 1;
		else if (moveDirection == 2)
			newX = x - 1;
		else if (moveDirection == 3)
			newX = x + 1;
		int[] returnValues = { newX, newY };
		return returnValues;
	}
}