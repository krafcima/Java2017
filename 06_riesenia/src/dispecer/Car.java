package dispecer;


public abstract class Car {
	GameBoard gb; 			// pointer to GameBoard
	protected int x1, y1;	// left-upper corner
	protected int x2, y2; 	// right-down corner
	public Car(GameBoard gb,  int x1, int y1, int x2, int y2) {
		this.x1 = x1; this.x2 = x2;
		this.y1 = y1; this.y2 = y2;
		this.gb = gb;
	}
	abstract boolean left();
	abstract boolean right();
	abstract boolean up();
	abstract boolean down();
	boolean inside(int x, int y) {
		return x1 <= x && x < x2 && y1 <= y && y < y2;
	}
}
