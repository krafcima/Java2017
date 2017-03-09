
public class Premenna extends Polynom {
	
	private String premenna;

	public Premenna(String premenna) {
		super();
		this.premenna = premenna;
	}

	public String getPremenna() {
		return premenna;
	}

	public void setPremenna(String premenna) {
		this.premenna = premenna;
	}

	@Override
	public String toString() {
		return premenna;
	}

	@Override
	Double valueAt(String[] vars, double[] values) {
		for (int i = 0; i < vars.length; i++) {
			if (vars[i].equals(premenna)) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	Polynom derive(String var) {
		if (var.equals(premenna)) {
			return new Konstanta(1); 
		}
		else {
			return new Konstanta(0);
		}
	}

	@Override
	Polynom simplify() {
		return this;
	}
	
	
}
