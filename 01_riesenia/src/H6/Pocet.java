
public class Pocet {

	public static void main(String[] args) {
		System.out.println(pocet(20));
		System.out.println(pocet(23));
		System.out.println(pocet(24));

	}

	public static int pocet(int n) {
		String cislo = Integer.toBinaryString(n);
		int pocet = 0;
		for (int i = 0; i < cislo.length(); i++) {
			if (cislo.charAt(i) == '1') {
				pocet++;
			}
		}
		return pocet;
	}

}
