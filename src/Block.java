import java.awt.Color;

public class Block extends Piece {

	public Block(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}

	public Block(int x, int y, Color c, Map m) {
		super(Piece.BLOCK, m);
		super.setXY(x, y);
		super.setColor(c);
	}

	@Override
	public void act() {

	}

	public String toString() {
		return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
	}
}
