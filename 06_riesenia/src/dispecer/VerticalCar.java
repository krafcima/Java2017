package dispecer;


public class VerticalCar extends Car  {
	public VerticalCar(GameBoard gb, int x1, int y1, int length) {
		super(gb,x1,y1,x1+length,y1+1);
	}
	public boolean up() {
		if (x1 > 0  && gb.inside(x1-1,y1) < 0) {
			x1--; x2--;
			return true;
		} else return false;
	}
	public boolean down() {
		if (x2< gb.SIZEX && gb.inside(x2,y1) < 0) {
			x1++; x2++;
			return true;
		} else 
			return false;
	}
	public boolean left() {
		return false;
	}
	public boolean right() {
		return false;
	}
}
