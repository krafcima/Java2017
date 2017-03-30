package H3;

public class Hodnota extends Vyraz {

	double hodnota;

	public Hodnota(double hodnota){
		this.hodnota = hodnota;
	}


	@Override
	public double vyhodnot() {
		return hodnota;
	}

	@Override
	public String toString() {
		return String.valueOf(this.hodnota);
	}
}
