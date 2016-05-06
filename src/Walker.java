import java.awt.Color;

public class Walker extends Piece {
	public Walker(int x, int y, int c, Map m) {
		this(x, y, Piece.determineColor(c), m);
	}

	public Walker(int x, int y, Color c, Map m) {
		super(Piece.WALKER, m);
		super.setXY(x, y);
		super.setColor(c);
	}

	@Override
	public void act() {
		if (Piece.rand(1, 3) == 1) {
			int x = super.getX();
			int y = super.getY();
			int moveDirection = Piece.rand(1, 4);
			int[] newXY = moveAccordingToDirection(moveDirection);  	
			move(x, y, newXY[0], newXY[1]);
		}

	}

	public String toString() {
		return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
	}
}
