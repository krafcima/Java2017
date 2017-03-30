package H3;

public abstract class Vyraz {
	abstract public double vyhodnot();
	abstract public String toString();

	public static void main(String[] args) {
		Vyraz v =
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

		System.out.println(v.toString());
		System.out.println(v.vyhodnot());
	}
}
