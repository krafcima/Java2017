package dispecer;


public class HorizontalCar extends Car  {

	public HorizontalCar(GameBoard gb, int x1, int y1, int length) {
		super(gb, x1,y1,x1+1,y1+length);
	}
	public boolean up() {
		return false;
	}
	public boolean down() { 
		return false;
	}
	public boolean right() {
	  if (y2 < gb.SIZEY && gb.inside(x1,y2) < 0) {	
		y1++; y2++;
		return true;
	  } else return false;
		
	}
	public boolean left() {
		if (y1 > 0 && gb.inside(x1,y1-1) < 0) {
			y1--; y2--;
			return true;
		} else
			return false;
	}
}
