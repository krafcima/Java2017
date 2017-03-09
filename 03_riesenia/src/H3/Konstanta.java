
public class Konstanta extends Polynom {
	
	private double konstanta;

	public Konstanta(double prem) {
		super();
		this.konstanta = prem;
	}

	public double getKonstanta() {
		return konstanta;
	}

	public void setKonstanta(double prem) {
		this.konstanta = prem;
	}

	@Override
	public String toString() {
		return ""+konstanta;
	}

	@Override
	Double valueAt(String[] vars, double[] values) {
		return konstanta;
	}

	@Override
	Polynom derive(String var) {
		// TODO Auto-generated method stub
		return new Konstanta(0);
	}

	@Override
	Polynom simplify() {		
		return this;
	}
	
	
	
	

}
