
public class pascal {
	
	public static long kombinacneCislo(int n, int k) {
		long hore = Faktorial.factorial(n);
		long dole = Faktorial.factorial(n-k)*Faktorial.factorial(k);
		return hore/dole;
	}
	public static long pascal(int n) {
		int k = n/2;
		return kombinacneCislo(n, k);
	}
	
	public static void main(String[] args) {
		System.out.println(pascal(4));
	}
}
