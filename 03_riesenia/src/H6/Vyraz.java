
public abstract class Vyraz {

	public static void main(String[] args) {
		Vyraz prvyVyraz =
				new Operacia("/",
					new Operacia("+",
						new Operacia("-",
							new Hodnota(7),
							new Hodnota(2)
							),
						new Operacia("*",
							new Hodnota(3),
							new Hodnota(2)
							)
						),
					new Hodnota(0.11)
					);
		System.out.println(prvyVyraz.vyhodnot());
		System.out.println(prvyVyraz);
	}

	abstract public double vyhodnot();
	abstract public String toString();
}

class Hodnota extends Vyraz {
	double hodnota;

	 Hodnota(double hodnota){
		 this.hodnota = hodnota;
	 }
	@Override
	public double vyhodnot() {
		return hodnota;
	}

	@Override
	public String toString() {
		return Double.toString(hodnota);
	}
}
class Operacia extends Vyraz {
	String operacia;
	Vyraz lavyOperand,pravyOperand;

	Operacia(String operacia, Vyraz lavyOperand, Vyraz pravyOperand){
		this.operacia = operacia;
		this.lavyOperand = lavyOperand;
		this.pravyOperand = pravyOperand;
	}
	@Override
	public double vyhodnot() {
		switch (operacia) {
		case "+":
			return lavyOperand.vyhodnot() + pravyOperand.vyhodnot();
		case "-":
			return lavyOperand.vyhodnot() - pravyOperand.vyhodnot();
		case "*":
			return lavyOperand.vyhodnot() * pravyOperand.vyhodnot();
		case "/":
			return lavyOperand.vyhodnot() / pravyOperand.vyhodnot();
		default:
			return 0;
		}
	}
	@Override
	public String toString() {
		return "(" + lavyOperand.toString() + operacia + pravyOperand.toString() + ")";
	}
}