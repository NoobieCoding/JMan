import java.awt.*;

/** An instance of this class is a J*Man.
 There should at most one J*Man in a game board at a time*/
public class JMan extends Piece {
	
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color red if c = 0, green if c = 1, and yellow if c = 2. */
    public JMan(int x, int y, int c, Map m){
        this(x, y, Piece.determineColor(c), m);
    }
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
    public JMan(int x, int y, Color c, Map m){
        super(Piece.JMAN, m);
        super.setXY(x, y);
        super.setColor(c);
    }
    
    /** J*Man should move based on what button is pushed.
     This method is not used. */
    public void act(){
        return;
    }
    
    /** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
    public void step(int i){
        setActed(true);
        int x = super.getX();
        int y = super.getY();
        int[] newXY = moveAccordingToDirection(i);     
        move(x, y, newXY[0], newXY[1]);
    }
    
    /** = representation of this piece */
    public String toString() {
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }  

}
