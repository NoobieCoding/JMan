import java.awt.Color;

public class Pillar extends Piece {
	public Pillar(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}

	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		super.setXY(x, y);
		super.setColor(c);
	}

	@Override
	public void act() {
		if (Piece.rand(1, 3) == 1)
			super.setColor(determineColor(rand(0, 2)));
	}

	public String toString() {
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}
}
