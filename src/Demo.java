import java.awt.Color;

public class Demo {
	public static void main(String[] args) {
		JMan theJ = new JMan(1, 1, Color.RED, new Map());
		System.out.println(theJ.getColorWord());
	}
}
